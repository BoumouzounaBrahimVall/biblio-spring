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
    public String saveLivre(@ModelAttribute("livre") Livre livre, @RequestParam("nbr") int nbr) {
        service.save(livre);
        for(int i = 0; i < nbr; i++) {
            serviceEx.save(new Exemplaire(i, livre));
        }
        return "redirect:/livre";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit_livre");
        Optional<Livre> l = service.get(id);
        mav.addObject("livre", l);
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteLivre(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/livre";
    }




}
