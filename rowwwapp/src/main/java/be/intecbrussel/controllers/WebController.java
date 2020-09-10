package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.Team;
import be.intecbrussel.repositories.CRUDOperationsRower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
    //With viewControllers, I give an urlPath to each page of the website that will
    // not directly be accessible by the user (views are made with the help of templates of the same name)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/rowwwapp/").setViewName("rowwwapp_index_page");
        registry.addViewController("/rowwwapp/competition/documents").setViewName("rowwwapp_competition_page_exports");
        registry.addViewController("/rowwwapp/registration/documents").setViewName("rowwwapp_registration_page_exports");
    }
   //Get methods are also mapped to a specific url. In their implementations, comes a showForm method with for argument(s)
    //a model so that the template can associate each fields of the forms to the models attributes. It return the name
    //of a template of the page

    @GetMapping("/rowwwapp/competition")
    public String showForm(Competition competitionForm){
        return "rowwwapp_competition_page";
    }
    @GetMapping("/rowwwapp/competition/race")
    public String showForm(Race raceForm){
        return "rowwwapp_competition_race_page";
    }
    @GetMapping("/rowwwapp/registration/rower")
    public String showForm(Rower rowerForm){
        return "rowwwapp_registration_rower_page";
    }
    @GetMapping("/rowwwapp/registration/team")
    public String showForm(Team teamForm){
        return "rowwwapp_registration_team_page";
    }
    //Deel Competition
    //PostMapping methods have a similar structure except that with @Validated and BindinResult, the business logic will
    //check if entries correspond to what is expected for each models and send the user to a page accordingly
    @PostMapping("/rowwwapp/competition")
    public String checkCompetitionInfos(@Validated Competition competitionForm, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_page";
        }
        return "redirect:/rowwwapp/competition/race";
    }
    @PostMapping("/rowwwapp/competition/race")
    public String checkRaceInfos(@Validated Race raceForm, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_race_page";
        }
        return "redirect:/rowwwapp/competition/documents";
    }
    ///////////////////////////Deel Registration//////////////////////////////////////////////////
    @PostMapping("/rowwwapp/registration/team")
    public String checkTeamInfos(@Validated Team teamForm, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_team_page";
        }
        return "redirect:/rowwwapp/registration/rower";
    }
    @PostMapping("/rowwwapp/registration/rower")
    public String checkRowerInfos(@Validated Rower rowerForm, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_rower_page";
        }
        return "redirect:/rowwwapp/registration/documents";
    }




}
