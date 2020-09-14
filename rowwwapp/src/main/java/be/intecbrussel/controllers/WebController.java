package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;

import be.intecbrussel.repositories.*;
import be.intecbrussel.viewResolvers.ExcelViewResolverRegistration;
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
    private final CRUDOperationsCompensation compensationRepository;
    private final CRUDOperationsCompetition competitionRepository;
    private final CRUDOperationsRace raceRepository;
    private final CRUDOperationsRower rowerRepository;
    private final CRUDOperationsScheduledRace scheduledRaceRepository;
    private final CRUDOperationsTeam teamRepository;

    @Autowired
    public WebController(CRUDOperationsCompensation compensationRepository, CRUDOperationsCompetition competitionRepository, CRUDOperationsRace raceRepository, CRUDOperationsRower rowerRepository, CRUDOperationsScheduledRace scheduledRaceRepository, CRUDOperationsTeam teamRepository) {
        this.compensationRepository = compensationRepository;
        this.competitionRepository = competitionRepository;
        this.raceRepository = raceRepository;
        this.rowerRepository = rowerRepository;
        this.scheduledRaceRepository = scheduledRaceRepository;
        this.teamRepository = teamRepository;
    }

   //Get methods are also mapped to a specific url. In their implementations, comes a showForm method with for argument(s)
    //a model so that the template can associate each fields of the forms to the models attributes. It return the name
    //of a template of the page

    @GetMapping("/rowwwapp")
    public String showWelcome(){
        return "rowwwapp_index_page";
    }
    ////////////////////////////Deel Competition//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/competition")
    public String showForm(Competition competitionForm2){ return "rowwwapp_competition_page"; }
    @GetMapping("/rowwwapp/competition/race")
    public String showRace(Race raceForm2){
        return "rowwwapp_competition_race_page";
    }
    @GetMapping("/rowwwapp/competition/compensation")
    public String showCompensation(Compensation compensationForm2){
        return "rowwwapp_competition_compensation_page";
    }
    @GetMapping("/rowwwapp/competition/results")
    public String showDownloadCompetition(){return "rowwwapp_competition_page_exports"; }
    ////////////////////////////Deel Registration//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/registration/scheduledRace")
    public String showRower(ScheduledRace scheduledRaceForm){
        return "rowwwapp_registration_scheduledRace_page";
    }

    @GetMapping("/rowwwapp/registration/rower")
    public String showRower(Rower rowerForm){
        return "rowwwapp_registration_rower_page";
    }
    @GetMapping("/rowwwapp/registration/rower/results")
    public String show(){return "rowwwapp_registration_rower_results";}

    @GetMapping("/rowwwapp/registration/team")
    public String showTeam(Team teamForm){
        return "rowwwapp_registration_team_page";
    }
    @GetMapping("/rowwwapp/registration/results")
    public String showDownloadRegistration(){return "rowwwapp_registration_page_exports"; }


    //PostMapping methods have a similar structure except that with @Validated and BindinResult, the business logic will
    //check if entries correspond to what is expected for each models and send the user to a page accordingly

    ////////////////////////////Deel Competition//////////////////////////////////////////////////
    @PostMapping("/rowwwapp/competition")
    public String checkCompetitionInfos(@Validated Competition competitionForm2, BindingResult bindingResult, Model model){

        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_page";
        }
        competitionRepository.save(competitionForm2);
        model.addAttribute("competitions", competitionRepository.findAll());
        return "redirect:/rowwwapp/competition/race";
    }
    @PostMapping("/rowwwapp/competition/race")
    public String checkRaceInfos(@Validated Race raceForm2, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_race_page";
        }
        raceRepository.save(raceForm2);
        model.addAttribute("races", raceRepository.findAll());
        return "redirect:/rowwwapp/competition/compensation";
    }
    @PostMapping("/rowwwapp/competition/compensation")
    public String checkCompensationInfos(@Validated Compensation compensationForm2, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_competition_compensation_page";
        }
        compensationRepository.save(compensationForm2);
        model.addAttribute("compensations", compensationRepository.findAll());
        return "redirect:/rowwwapp/competition/results";
    }
    ///////////////////////////Deel Registration//////////////////////////////////////////////////
    @PostMapping("/rowwwapp/registration/scheduledRace")
    public String checkTeamInfos(@Validated ScheduledRace scheduledRaceForm, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_scheduledRace_page";
        }
        scheduledRaceRepository.save(scheduledRaceForm);
        model.addAttribute("scheduledRaces", scheduledRaceRepository.findAll());
        return "redirect:/rowwwapp";
    }
    @PostMapping("/rowwwapp/registration/rower")
    public String checkTeamInfos(@Validated Rower rowerForm, BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_rower_page";
        }
        rowerRepository.save(rowerForm);
        model.addAttribute("rowers", rowerRepository.findAll());
        return "redirect:/rowwwapp/registration/rower/results";
    }
    @PostMapping("/rowwwapp/registration/team")
    public String checkRowerInfos(@Validated Team teamForm, BindingResult bindingResult,Model model){
        if(bindingResult.hasFieldErrors()){
            return "rowwwapp_registration_team_page";
        }
        teamRepository.save(teamForm);
        model.addAttribute("teams", teamRepository.findAll());
        return "redirect:/rowwwapp/registration/results";
    }




}
