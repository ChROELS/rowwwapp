package be.intecbrussel.service;

import be.intecbrussel.models.competition.Competition;
import be.intecbrussel.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompetitionService {
    private final CRUDOperationsCompetition competitionRepository;

    @Autowired
    public CompetitionService(CRUDOperationsCompetition competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    //Competition
    public void createCompetitionDay(Competition competition){
        competitionRepository.save(competition);
    }
    public boolean updateCompetitionDay(Competition competition, Competition newCompetition){
        Optional<Competition> competition1 = competitionRepository.findById(competition.getId());
        if(competition1.isPresent()){
            competitionRepository.delete(competition1.get());
            competitionRepository.save(newCompetition);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteCompetionDay(Competition competition){
        boolean idExists = competitionRepository.existsById(competition.getId());
        if(idExists) {
            competitionRepository.delete(competition);
            return true;
        }else{
            return false;
        }
    }
}
