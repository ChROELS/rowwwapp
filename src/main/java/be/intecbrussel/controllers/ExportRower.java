package be.intecbrussel.controllers;

import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.Team;
import be.intecbrussel.repositories.CRUDOperationsRower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExportRower {
    @Autowired
    private CRUDOperationsRower rowers;
    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/rowwwapp/registration/documents/rower", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("rowers", rowers.findAll());
        return "";
    }
}
