package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.repositories.CRUDOperationsRace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ExportRace {
    @Autowired
    private CRUDOperationsRace races;
    /**
     * Handle request to download an Excel document
     */
    @RequestMapping(value = "/rowwwapp/competition/documents/race", method = RequestMethod.GET)
    public String download(Model model) {
        model.addAttribute("races", races.findAll());
        return "";
    }
}
