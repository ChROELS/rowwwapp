package be.intecbrussel.service.registrationServices;

import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.models.registration.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExportServiceRegistration {
    List<Rower> rowerList = new ArrayList<>();
    List<Team> teamList = new ArrayList<>();
    List<ScheduledRace> scheduledRaceList = new ArrayList<>();
    RowerService service;
    ScheduledRaceService scheduledRaceService;
    TeamService teamService;

    @Autowired
    public ExportServiceRegistration(RowerService service, ScheduledRaceService scheduledRaceService, TeamService teamService) {
        this.service = service;
        this.scheduledRaceService = scheduledRaceService;
        this.teamService = teamService;
    }


    public void addRegisteredRowers(List<Rower> data){
        rowerList.addAll(data);
    }
    public void addRegisteredTeams(List<Team> data){
        teamList.addAll(data);
    }
    public void addRegisteredRaces(List<ScheduledRace> data){
        scheduledRaceList.addAll(data);
    }

    public List<Rower> getRowersList() {
        addRegisteredRowers(service.getAllRowers());
        return rowerList;
    }
    public List<ScheduledRace> getScheduledRacesList() {
        addRegisteredRaces(scheduledRaceService.getAllScheduledRaces());
        return scheduledRaceList;
    }
    public List<Team> getTeamsList() {
        addRegisteredTeams(teamService.getAllTeams());
        return teamList;
    }
}
