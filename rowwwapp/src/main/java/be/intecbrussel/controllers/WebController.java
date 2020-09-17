package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;

import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;
import be.intecbrussel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
@RequestMapping("/")
public class WebController implements WebMvcConfigurer {

private final CompetitionService competitionService;
private final RaceService raceService;
private final CompensationService compensationService;
private final RowerService rowerService;
private final ScheduledRaceService scheduledRaceService;
private final TeamService teamService;

    @Autowired
    public WebController(CompetitionService competitionService, RaceService raceService, CompensationService compensationService, RowerService rowerService, ScheduledRaceService scheduledRaceService, TeamService teamService) {
        this.competitionService = competitionService;
        this.raceService = raceService;
        this.compensationService = compensationService;
        this.rowerService = rowerService;
        this.scheduledRaceService = scheduledRaceService;
        this.teamService = teamService;
    }





    /**Get methods are also mapped to a specific url. In their implementations, comes a showForm method with for argument(s)
    *a model so that the template can associate each fields of the forms to the models attributes. It return the name
    *of a template of the page*/

    /**PostMapping methods have a similar structure except that with @Validated and BindinResult, the business logic will
     *check if entries correspond to what is expected for each models and send the user to a page accordingly +
     * One of the cool things about Spring MVC is that it will take your form parameters and automatically bind them to a Product object.
     * The object is automatically created and passed into your controller method.
     * The Spring Framework saves you from the mundane work of parsing out HTTP request parameters.*/


    ////////////////////////////Deel Competition//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/competition")
    public String showForm(Model model){
        Competition competitionForm2 = new Competition();
        model.addAttribute("competitionForm2", competitionForm2);
        return "rowwwapp_competition_page"; }
    @PostMapping("/rowwwapp/competition")
    public String checkCompetitionInfos(@Validated Competition competitionForm2, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_page";
        }else {
            competitionService.createCompetitionDay(competitionForm2);
        }
        return "redirect:/rowwwapp/competition/race";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/race")
    public String showRace(Model model){
        model.addAttribute("raceForm2", new Race());
        return "rowwwapp_competition_race_page";
    }
    @PostMapping("/rowwwapp/competition/race")
    public String checkRaceInfos(@Validated Race raceForm2, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_race_page";
        }else {
            raceService.createRace(raceForm2);
        }
        return "redirect:/rowwwapp/competition/compensation";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/compensation")
    public String showCompensation(Model model){
        model.addAttribute("compensationForm2", new Compensation());
        return "rowwwapp_competition_compensation_page";
    }
    @PostMapping("/rowwwapp/competition/compensation")
    public String checkCompensationInfos(@Validated Compensation compensationForm2, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_compensation_page";
        }
        compensationService.createCompensation(compensationForm2);
        return "redirect:/rowwwapp/competition/results";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/results")
    public String showDownloadCompetition(){return "rowwwapp_competition_page_exports"; }

    @GetMapping("/rowwwapp/competition/results/document")
    public void showDownloadXlsCompetition(Model model) {

    }

    ////////////////////////////Deel Registration//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/registration/scheduledRace")
    public String showScheduledRace(Model model){
        model.addAttribute("scheduledRaceForm", new ScheduledRace());
        return "rowwwapp_registration_scheduledRace_page";
    }
    @PostMapping("/rowwwapp/registration/scheduledRace")
    public String checkScheduledRace(@Validated ScheduledRace scheduledRaceForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_scheduledRace_page";
        }
        scheduledRaceService.createScheduledRace(scheduledRaceForm);
        return "redirect:/rowwwapp";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/registration/rower")
    public String showRower(Model model){
        model.addAttribute("rowerForm",new Rower());
        return "rowwwapp_registration_rower_page";
    }
    @PostMapping("/rowwwapp/registration/rower")
    public String checkRower(@Validated Rower rowerForm, BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_rower_page";
        }
        rowerService.createRower(rowerForm);
        return "redirect:/rowwwapp/registration/rower/results";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/registration/team")
    public String showTeam(Model model){
        model.addAttribute("teamForm", new Team());
        return "rowwwapp_registration_team_page";
    }
    @PostMapping("/rowwwapp/registration/team")
    public String checkTeam(@Validated Team teamForm, BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_team_page";
        }
        teamService.createTeam(teamForm);
        return "redirect:/rowwwapp/registration/results";
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/registration/rower/results")
    public String show(){return "rowwwapp_registration_rower_results";}
    @GetMapping("/rowwwapp/registration/results")
    public String showDownloadRegistration(){return "rowwwapp_registration_page_exports"; }

    @GetMapping("/rowwwapp/registration/results/document")
    public String showDownloadXls(Model model) {
        return "redirect:/rowwwapp";
    }
}
