package be.intecbrussel.controllers;

import be.intecbrussel.repositories.CRUDOperationsCompensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExportCompensations {
    private CRUDOperationsCompensation compensations;

    @Autowired
    public ExportCompensations(CRUDOperationsCompensation compensations) {
        this.compensations = compensations;
    }

    @GetMapping("/rowwwapp/competition/results/compensation")
    public String download(Model model){
        model.addAttribute("compensation",compensations.toString());
        return "redirect:/rowwwapp/competition/documents";
    }
}
