package ma.fstm.ilisi.springbiblio.controller;

import ma.fstm.ilisi.springbiblio.bo.Adherant;
import ma.fstm.ilisi.springbiblio.bo.Emprunt;
import ma.fstm.ilisi.springbiblio.bo.EmpruntId;
import ma.fstm.ilisi.springbiblio.bo.Exemplaire;
import ma.fstm.ilisi.springbiblio.service.AdherantService;
import ma.fstm.ilisi.springbiblio.service.EmpruntService;
import ma.fstm.ilisi.springbiblio.service.ExemplaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntService service;
    @Autowired
    private AdherantService serviceAds;
    @Autowired
    private ExemplaireService serviceEx;

    public EmpruntController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewEmpruntPage(Model model) {
        List<Emprunt> listEmprunts = service.listAll();
        model.addAttribute("listEmprunts", listEmprunts);

        return "gerer_emprunt";
    }

    @RequestMapping("/new")
    public String showNewEmpruntPage(Model model) {
        Emprunt emprunt = new Emprunt();
        List<Exemplaire> listExemplaires=serviceEx.findFreeExemplaire();
        List<Adherant> listAdherants=serviceAds.listAll();

        model.addAttribute("emprunt", emprunt);
        model.addAttribute("listExemplaires",listExemplaires);
        model.addAttribute("listAdherants",listAdherants);

        return "new_emprunt";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmprunt(@ModelAttribute("emprunt") Emprunt l) {
        l.getId().setDateemp(LocalDate.now().toString());
        service.save(l);
        return "redirect:/emprunt";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEmprunt(@PathVariable(name = "id") String id) {
        service.delete(EmpruntId.parseString(id));
        return "redirect:/emprunt";
    }
}


