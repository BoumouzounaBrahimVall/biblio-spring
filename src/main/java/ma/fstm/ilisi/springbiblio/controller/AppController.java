package ma.fstm.ilisi.springbiblio.controller;

import ma.fstm.ilisi.springbiblio.bo.Livre;
import ma.fstm.ilisi.springbiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class AppController {
    @Autowired
    private LivreService service;

    public AppController(){}
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Livre> listLivres = service.listAll();
        model.addAttribute("listLivres",listLivres);

        return "index";
    }
    @RequestMapping("/livre/new")
    public String showNewLivrePage(Model model){
        Livre l=new Livre();
        model.addAttribute("livre",l);

        return "new_livre";
    }
    @RequestMapping(value = "/livre/save", method = RequestMethod.POST)
    public String saveLivre(@ModelAttribute("livre") Livre l) {
        service.save(l);
        return "redirect:/";
    }

    @RequestMapping("/livre/edit/{id}")
    public ModelAndView showEditLivrePage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit_livre");
        Optional<Livre> l = service.get(id);
        mav.addObject("livre", l);
        return mav;
    }
    @RequestMapping("/livre/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/";
    }




}
