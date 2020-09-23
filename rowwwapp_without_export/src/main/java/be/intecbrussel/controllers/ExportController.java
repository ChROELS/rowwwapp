package be.intecbrussel.controllers;

import be.intecbrussel.service.*;
import be.intecbrussel.views.ExcelViewCompetition;
import be.intecbrussel.views.ExcelViewRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExportController {
    private final RowerService rowerService;
    private final ScheduledRaceService scheduledRaceService;
    private final TeamService teamService;
    private final CompetitionService competitionService;
    private final CompensationService compensationService;
    private final RaceService raceService;


    @Autowired
    public ExportController(RowerService rowerServiceService, ScheduledRaceService scheduledRaceService, TeamService teamService, CompetitionService competitionService, CompensationService compensationService, RaceService raceService) {
        this.rowerService = rowerServiceService;
        this.scheduledRaceService = scheduledRaceService;
        this.teamService = teamService;
        this.competitionService = competitionService;
        this.compensationService = compensationService;
        this.raceService = raceService;

    }

    /**
     * Handle request to download an Excel document in the part "Competition"
     */
    @GetMapping("/rowwwapp/competition/results/rowwwapp_competition_data.xls")
    public ExcelViewCompetition downloadCompetitionDatas(Model model) {
        model.addAttribute("competitions", competitionService.getAllCompetitionDay());
        model.addAttribute("races", raceService.getAllRace());
        model.addAttribute("compensations", compensationService.getAllCompensations());
        return new ExcelViewCompetition();
    }
    /**
     * Handle request to download an Excel document in the part "Registration"
     */
    @GetMapping("/rowwwapp/registration/results/rowwwapp_registration_data.xls")
    public ExcelViewRegistration downloadRegistrationDatas(Model model) {
        model.addAttribute("rowers", rowerService.getAllRowers());
        model.addAttribute("teams", teamService.getAllTeams());
        model.addAttribute("scheduledRaces", scheduledRaceService.getAllScheduledRaces());
        return new ExcelViewRegistration();
    }
}
