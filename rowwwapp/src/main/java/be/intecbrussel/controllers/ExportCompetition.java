package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExportCompetition {
    @Autowired
    private Competition competition;
    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/rowwwapp/competition/documents/competition", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("competition", competition.toString());
        return "";
    }
}
