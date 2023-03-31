
package ma.fstm.ilisi.springbiblio.controller;

import ma.fstm.ilisi.springbiblio.bo.Adherant;
import ma.fstm.ilisi.springbiblio.service.AdherantService;
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
@RequestMapping("/adherant")
public class AdherantController {
    @Autowired
    private AdherantService service;

    public AdherantController(){}
    @RequestMapping(method = RequestMethod.GET)
    public String viewAdherantPage(Model model){
        List<Adherant> listAdherants = service.listAll();
        model.addAttribute("listAdherant",listAdherants);

        return "gerer_adherant";
    }
    @RequestMapping("/new")
    public String showNewAdherantPage(Model model){
        Adherant l=new Adherant();
        model.addAttribute("adherant",l);

        return "new_adherant";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAdherant(@ModelAttribute("adherant") Adherant l) {
        service.save(l);
        return "redirect:/adherant";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAdherantPage(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("edit_adherant");
        Optional<Adherant> l = service.get(id);
        mav.addObject("adherant", l.get());
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String deleteAdherant(@PathVariable(name = "id") String id) {
        service.delete(id);
        return "redirect:/adherant";
    }




}
