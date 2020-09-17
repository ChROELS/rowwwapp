package be.intecbrussel.service;

import be.intecbrussel.models.competition.Compensation;
import be.intecbrussel.repositories.CRUDOperationsCompensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompensationService {
    private final CRUDOperationsCompensation compensationRepository;

    @Autowired
    public CompensationService(CRUDOperationsCompensation compensationRepository) {
        this.compensationRepository = compensationRepository;
    }


    public void createCompensation(Compensation compensation){
        compensationRepository.save(compensation);
    }
    public boolean updateCompetitionDay(Compensation compensation, Compensation newCompensation){
        Optional<Compensation> compensation1 = compensationRepository.findById(compensation.getId());
        if(compensation1.isPresent()){
            compensationRepository.delete(compensation1.get());
            compensationRepository.save(newCompensation);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteCompensation(Compensation compensation){
        boolean idExists = compensationRepository.existsById(compensation.getId());
        if(idExists) {
            compensationRepository.delete(compensation);
            return true;
        }else{
            return false;
        }
    }
}
