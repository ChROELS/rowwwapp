package be.intecbrussel.service.competitionServices;


import be.intecbrussel.models.competition.Race;
import be.intecbrussel.repositories.CRUDOperationsRace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private final CRUDOperationsRace raceRepository;

    @Autowired
    public RaceService(CRUDOperationsRace raceRepository1) {
        this.raceRepository = raceRepository1;
    }


    public void createRace(Race race){
        raceRepository.save(race);
    }
    public boolean updateRace(Race race, Race newRace){
        Optional<Race> race1 = raceRepository.findById(race.getId());
        if(race1.isPresent()){
            raceRepository.delete(race1.get());
            raceRepository.save(newRace);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteRace(Race race){
        boolean idExists = raceRepository.existsById(race.getId());
        if(idExists) {
            raceRepository.delete(race);
            return true;
        }else{
            return false;
        }
    }
    public List<Race> getAllRace(){
        return (List<Race>) (raceRepository.findAll());
    }
}
