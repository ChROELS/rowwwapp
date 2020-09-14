package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import be.intecbrussel.repositories.CRUDOperationsCompetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExportCompetition {

    private CRUDOperationsCompetition competition;
    @Autowired
    public ExportCompetition(CRUDOperationsCompetition competition) {
        this.competition = competition;
    }

    /**
     * Handle request to download an Excel document
     */
    @GetMapping(value = "/rowwwapp/competition/results/competition")
    public String download(Model model) {
        model.addAttribute("competition", competition.toString());
        return "redirect:/rowwwapp/competition/documents";
    }
}
