package be.intecbrussel.repositories;

import be.intecbrussel.models.registration.ScheduledRace;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CRUDOperationsScheduledRace extends CrudRepository<ScheduledRace,Long> {

}
