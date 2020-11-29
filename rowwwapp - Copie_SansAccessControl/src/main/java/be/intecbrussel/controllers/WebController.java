package be.intecbrussel.controllers;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;

import be.intecbrussel.models.competition.Race;
import be.intecbrussel.models.enums.Position;
import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;
import be.intecbrussel.service.competitionServices.CompensationService;
import be.intecbrussel.service.competitionServices.CompetitionService;
import be.intecbrussel.service.competitionServices.RaceService;
import be.intecbrussel.service.registrationServices.RowerService;
import be.intecbrussel.service.registrationServices.ScheduledRaceService;
import be.intecbrussel.service.registrationServices.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;


/**Get methods are also mapped to a specific url. In their implementations, comes a showForm method with for argument(s)
 * a model so that the template can associate each fields of the forms to the models attributes. It return the name
 * of a template of the page.
 * PostMapping methods have a similar structure except that with @Validated and BindingResult (note that the order of parameters is important), the business logic will
 * check if entries correspond to what is expected for each models and send the user to a page accordingly +
 * One of the cool things about Spring MVC is that it will take your form parameters and automatically bind them to a Product object.
 * The object is automatically created and passed into your controller method.
 * The Spring Framework saves you from the mundane work of parsing out HTTP request parameters.*/

@Controller
@RequestMapping("/")
public class WebController implements WebMvcConfigurer {

private final CompetitionService competitionService;
private final RaceService raceService;
private final CompensationService compensationService;
private final RowerService rowerService;
private final ScheduledRaceService scheduledRaceService;
private final TeamService teamService;
private Rower rowerToSave;
private ScheduledRace scheduledRaceToSave;
private Team teamToSave;
private List<Rower> rowersToSave = new ArrayList<>();
private Competition competitionToSave;
private Race raceToSave;
private List<Race> raceListToSave = new ArrayList<>();
private Compensation compensationToSave;


    @Autowired
    public WebController(CompetitionService competitionService, RaceService raceService, CompensationService compensationService, RowerService rowerService, ScheduledRaceService scheduledRaceService, TeamService teamService) {
        this.competitionService = competitionService;
        this.raceService = raceService;
        this.compensationService = compensationService;
        this.rowerService = rowerService;
        this.scheduledRaceService = scheduledRaceService;
        this.teamService = teamService;
    }

    ////////////////////////////Deel Competition//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/competition")
    public String showCompetition(Model model){
        model.addAttribute("competitionForm2",new Competition());
        return "rowwwapp_competition_page"; }
    @PostMapping("/rowwwapp/competition")
    public String checkAndCreateCompetitionInfos(Competition competitionForm2, Model model){
            model.addAttribute("competitionForm2",competitionForm2);
            competitionToSave = (Competition) model.getAttribute("competitionForm2");
            return "redirect:/rowwwapp/competition/race";

    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/race")
    public String showRace(Model model){
        model.addAttribute("raceForm2", new Race());
        model.addAttribute("competitions", competitionToSave);
        model.addAttribute("races", raceListToSave);
        return "rowwwapp_competition_race_page";
    }
    @PostMapping("/rowwwapp/competition/race")
    public String checkRaceInfos(Race raceForm2,Model model){
        model.addAttribute("raceForm2", raceForm2);
        model.addAttribute("competitions", competitionToSave);
        model.addAttribute("races", raceListToSave);
        raceToSave = (Race) model.getAttribute("raceForm2");
        if(raceToSave!=null) {
            raceToSave.setName();
            raceToSave.setCompetition(competitionToSave);
            raceListToSave.add(raceToSave);
        }
            if(raceForm2.getLastRace().equals("non")) {
                return "redirect:/rowwwapp/competition/compensation";
            }else{
                return "redirect:/rowwwapp/competition/race";
            }
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/compensation")
    public String showCompensation(Model model){
        model.addAttribute("compensationForm2", new Compensation());
        model.addAttribute("races", raceListToSave);
        model.addAttribute("competitions", competitionToSave);
        return "rowwwapp_competition_compensation_page";
    }
    @PostMapping("/rowwwapp/competition/compensation")
    public String checkCompensationInfos(Compensation compensationForm2,Model model){
        model.addAttribute("compensationForm2",compensationForm2);
        compensationToSave = (Compensation) model.getAttribute("compensationForm2");
        if(compensationToSave!=null) {
            compensationToSave.setCompetition(competitionToSave);
        }
        for (Race r: raceListToSave
             ) {
            competitionToSave.addRace(raceToSave);
            raceService.createRace(r);
        }
        competitionService.createCompetitionDay(competitionToSave);
        compensationService.createCompensation(compensationToSave);
        return "redirect:/rowwwapp/competition/results";

    }
    //****************************************************************//
    @GetMapping("/rowwwapp/competition/results")
    public String showDownloadCompetition(Model model){
        Map<String,List> attributes = new TreeMap<>();
        attributes.put("competitions", competitionService.getAllCompetitionDay());
        attributes.put("races", raceService.getAllRace());
        attributes.put("compensations",compensationService.getAllCompensations());
        model.addAllAttributes(attributes);
        return "rowwwapp_competition_page_exports"; }


    ////////////////////////////Deel Registration//////////////////////////////////////////////////
    @GetMapping("/rowwwapp/registration/scheduledRace")
    public String showScheduledRace(Model model){
        model.addAttribute("scheduledRaceForm", new ScheduledRace());
        return "rowwwapp_registration_scheduledRace_page";
    }
    @PostMapping("/rowwwapp/registration/scheduledRace")
    public String checkScheduledRace(ScheduledRace scheduledRaceForm,Model model){
        model.addAttribute("scheduledRaceForm", scheduledRaceForm);
        scheduledRaceToSave = (ScheduledRace)model.getAttribute("scheduledRaceForm");
        return "redirect:/rowwwapp/registration/rower";

    }
    //****************************************************************//
    @GetMapping("/rowwwapp/registration/rower")
    public String showRower(Model model){
        model.addAttribute("rowerForm",new Rower());
        model.addAttribute("scheduledRaceForm", scheduledRaceToSave);
        return "rowwwapp_registration_rower_page";
    }
    @PostMapping("/rowwwapp/registration/rower")
    public String checkRower(Rower rowerForm,Model model){
        model.addAttribute("rowerForm", rowerForm);
        model.addAttribute("scheduledRaceForm", scheduledRaceToSave);
        //transient object to populate
        rowerToSave = (Rower) model.getAttribute("rowerForm");
        try{
            if (rowerToSave != null) {
                rowerToSave.setAge();
                rowerToSave.setCategory();
                rowerToSave.setRace(scheduledRaceToSave);
                rowerToSave.setGenderCoef(scheduledRaceToSave.getCoefficientGender());
                rowerToSave.setCategoryCoef(scheduledRaceToSave.getCoefficientCategory());
                rowerToSave.setRowerHandicap();
                rowersToSave.add(rowerToSave);
            }
            if (rowerForm.getIsLastRower().equals("oui")) {
                return "redirect:/rowwwapp/registration/rower";
            } else {
                return "redirect:/rowwwapp/registration/team";
            }
        }catch(Exception e){
            return "redirect:/rowwwapp/registration/rower";
        }
    }
    //****************************************************************//
    @GetMapping("/rowwwapp/registration/team")
    public String showTeam(Model model){
        model.addAttribute("teamForm", new Team());
        model.addAttribute("scheduledRaceForm", scheduledRaceToSave);
        model.addAttribute("rowerForm", rowersToSave);
        return "rowwwapp_registration_team_page";
    }
    @PostMapping("/rowwwapp/registration/team")
    public String checkTeam(Team teamForm,Model model){
        model.addAttribute("teamForm",teamForm);
        //transient object to populate
        teamToSave = (Team) model.getAttribute("teamForm");
        try {
            if (teamToSave != null) {
                for (int i = 0; i < rowersToSave.size(); i++) {
                    rowersToSave.get(i).setTeam(teamToSave);
                    teamToSave.addCrewMember(rowersToSave.get(i));
                    teamToSave.setCox(rowersToSave.get(i).getPosition() == Position.COX ? rowersToSave.get(i) : null);
                    teamToSave.setStroke(rowersToSave.get(i).getPosition() == Position.STROKE ? rowersToSave.get(i) : null);
                }
                teamToSave.setTeamHandicap();
            }
            //This order --> rower/team/race objects -- to avoid Hibernate PersistentObjectException
            for (int i = 0; i < rowersToSave.size(); i++) {
                rowerService.createRower(rowersToSave.get(i));
            }
            scheduledRaceToSave.setTeam(teamToSave);
            teamService.createTeam(teamToSave);
            scheduledRaceService.createScheduledRace(scheduledRaceToSave);
            return "redirect:/rowwwapp/registration/results";
        }catch (Exception e){
            return "redirect:/rowwwapp/registration/team";
        }
    }



    //****************************************************************//
    @GetMapping("/rowwwapp/registration/results")
    public String show(Model model){
        model.addAttribute("scheduledRaces", scheduledRaceService.getAllScheduledRaces());
        model.addAttribute("teams",teamService.getAllTeams());
        model.addAttribute("rowers",rowerService.getAllRowers());
        return "rowwwapp_registration_page_exports";}
    @PostMapping("/rowwwapp/registration/results")
    public String deleteTeam(String name, Model model){
        model.addAttribute("scheduledRaces", scheduledRaceService.getAllScheduledRaces());
        model.addAttribute("rowers",rowerService.getAllRowers());
        model.addAttribute("teams",teamService.getAllTeams());
        return "rowwwapp_registration_page_exports";
    }
    //****************************************************************//

}
