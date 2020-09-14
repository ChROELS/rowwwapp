package be.intecbrussel.controllers;

import be.intecbrussel.models.registration.Team;
import be.intecbrussel.repositories.CRUDOperationsRower;
import be.intecbrussel.repositories.CRUDOperationsTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ExportTeam {

    private CRUDOperationsTeam teams;
    @Autowired
    public ExportTeam(CRUDOperationsTeam teams) {
        this.teams = teams;
    }

    /**
     * Handle request to download an Excel document
     */
    @GetMapping(value = "/rowwwapp/registration/results/team")
    public String download(Model model) {
        model.addAttribute("teams", teams.findAll());
        return "redirect:/rowwwapp/registration/documents";
    }
}
