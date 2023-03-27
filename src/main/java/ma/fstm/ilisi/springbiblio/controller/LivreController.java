package ma.fstm.ilisi.springbiblio.controller;

import ma.fstm.ilisi.springbiblio.bo.Exemplaire;
import ma.fstm.ilisi.springbiblio.bo.Livre;
import ma.fstm.ilisi.springbiblio.service.ExemplaireService;
import ma.fstm.ilisi.springbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Controller
@RequestMapping("/livre")
public class LivreController {
    @Autowired
    private LivreService service;
    @Autowired
    private ExemplaireService serviceEx;
    public LivreController(){}
    @RequestMapping(method = RequestMethod.GET)
    public String viewLivrePage(Model model){
        List<Livre> listLivres = service.listAll();
        model.addAttribute("listLivres",listLivres);

        return "gerer_livre";
    }
    @RequestMapping("/new")
    public String showNewLivrePage(Model model){
        Livre l=new Livre();
        model.addAttribute("livre",l);
        return "new_livre";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("livre") Livre livre, @RequestParam("nbr") long nbr) {
        Optional<Livre> l = service.get(livre.getIsbn());
        service.save(livre);
        if ( l.isPresent() ){
           Livre ll= l.get();
           long countExp=serviceEx.findByIsbn(ll.getIsbn()).size();
           long change=nbr - countExp;
           long explaireEmprut=serviceEx.findEmpruntedByIsbn(ll.getIsbn()).size();
           if(change>=0) {
               for(long i=0;i<change;i++)  serviceEx.save(new Exemplaire( livre));

           }else if((explaireEmprut-change)<=countExp){
               long i=-change;
               List<Exemplaire> empruLivs=serviceEx.findEmpruntedByIsbn(ll.getIsbn());
               for(Exemplaire e: serviceEx.findByIsbn(ll.getIsbn())){
                   System.out.println("change : "+e.getIdexp());
                   if(i==0) break;
                   if(!empruLivs.contains(e)){
                       serviceEx.delete(e.getIdexp());
                       i--;
                   }
               }
           }else {// 5 exp  3 emprunt retreiveExpEmprunt
               return "redirect:/error";
           }
       }else {
            for (long i = 0; i < nbr; i++) {
                serviceEx.save(new Exemplaire( livre));
            }
        }
        return "redirect:/livre";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit_livre");
        Optional<Livre> l = service.get(id);
        mav.addObject("livre", l.get());
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteLivre(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/livre";
    }




}
