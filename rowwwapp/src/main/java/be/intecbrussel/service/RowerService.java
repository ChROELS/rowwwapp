package be.intecbrussel.service;

import be.intecbrussel.models.registration.Rower;
import be.intecbrussel.repositories.CRUDOperationRower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RowerService {
    private final CRUDOperationRower rowerRepository;

    @Autowired
    public RowerService(CRUDOperationRower rowerRepository) {
        this.rowerRepository = rowerRepository;
    }

    //Competition
    public void createRower(Rower rower){
        rowerRepository.save(rower);
    }
    public boolean updateRower(Rower rower, Rower newRower){
        Optional<Rower> rower1 = rowerRepository.findById(rower.getId());
        if(rower1.isPresent()){
            rowerRepository.delete(rower1.get());
            rowerRepository.save(newRower);
            return true;
        }else{
            return false;
        }
    }
    public boolean deleteRower(Rower rower){
        boolean idExists = rowerRepository.existsById(rower.getId());
        if(idExists) {
            rowerRepository.delete(rower);
            return true;
        }else{
            return false;
        }
    }
    public List<Rower> findAllRowers(){
        return (List<Rower>) rowerRepository.findAll();
    }
}
