package be.intecbrussel.service;

import be.intecbrussel.models.registration.ScheduledRace;
import be.intecbrussel.repositories.CRUDOperationsScheduledRace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduledRaceService {
    private final CRUDOperationsScheduledRace operationsScheduledRace;

    @Autowired
    public ScheduledRaceService(CRUDOperationsScheduledRace scheduledRaceRepository) {
        this.operationsScheduledRace = scheduledRaceRepository;
    }

    //Competition
    public void createScheduledRace(ScheduledRace race){
        operationsScheduledRace.save(race);
    }
    public boolean updateScheduledRace(ScheduledRace race, ScheduledRace newRace){
        Optional<ScheduledRace> race1 = operationsScheduledRace.findById(race.getId());
        if(race1.isPresent()){
            operationsScheduledRace.delete(race1.get());
            operationsScheduledRace.save(newRace);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteScheduledRace(ScheduledRace race){
        boolean idExists = operationsScheduledRace.existsById(race.getId());
        if(idExists) {
            operationsScheduledRace.delete(race);
            return true;
        }else{
            return false;
        }
    }
}
