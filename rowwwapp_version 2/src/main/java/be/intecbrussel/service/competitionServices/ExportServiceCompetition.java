package be.intecbrussel.service.competitionServices;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.models.competition.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExportServiceCompetition {
    List<Competition> competitionList = new ArrayList<>();
    List<Race> raceList = new ArrayList<>();
    List<Compensation> compensationList = new ArrayList<>();
    CompetitionService service;
    RaceService raceService;
    CompensationService compensationService;

    @Autowired
    public ExportServiceCompetition(CompetitionService service, RaceService raceService, CompensationService compensationService) {
        this.service = service;
        this.raceService = raceService;
        this.compensationService = compensationService;
    }

    public void addRegistered(List<Competition> data){
        competitionList.addAll(data);
    }
    public void addRegisteredRace(List<Race> data){
        raceList.addAll(data);
    }
    public void addRegisteredCompensation(List<Compensation> data){
        compensationList.addAll(data);
    }
    public List<Competition> getCompetitionList() {
        addRegistered(service.getAllCompetitionDay());
        return competitionList;
    }
    public List<Race> getRacesList() {
        addRegisteredRace(raceService.getAllRace());
        return raceList;
    }
    public List<Compensation> getCompensationsList() {
        addRegisteredCompensation(compensationService.getAllCompensations());
        return compensationList;
    }
}
