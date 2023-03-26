package ma.fstm.ilisi.springbiblio.controller;

import ma.fstm.ilisi.springbiblio.bo.Emprunt;
import ma.fstm.ilisi.springbiblio.bo.EmpruntId;
import ma.fstm.ilisi.springbiblio.service.EmpruntService;
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
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntService service;

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
        Emprunt l = new Emprunt();
        model.addAttribute("emprunt", l);

        return "new_emprunt";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEmprunt(@ModelAttribute("emprunt") Emprunt l) {
        service.save(l);
        return "redirect:/emprunt";
    }

    @RequestMapping("/edit/{idExp}/{idAd}/{dateEmp}")
    public ModelAndView showEditEmpruntPage(@PathVariable(name = "idExp") int idExp,@PathVariable(name = "idAd") String idAd,@PathVariable(name = "dateEmp") String dateEmp) {
        ModelAndView mav = new ModelAndView("edit_emprunt");
        Optional<Emprunt> l = service.get(new EmpruntId(idExp,idAd,dateEmp));
        mav.addObject("emprunt", l);
        return mav;
    }

    @RequestMapping("/delete/{idExp}/{idAd}/{dateEmp}")
    public String deleteEmprunt(@PathVariable(name = "idExp") int idExp,@PathVariable(name = "idAd") String idAd,@PathVariable(name = "dateEmp") String dateEmp) {
        service.delete(new EmpruntId(idExp,idAd,dateEmp));
        return "redirect:/emprunt";
    }
}


