package be.intecbrussel.repositories;

import be.intecbrussel.models.registration.Rower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDOperationsRower extends CrudRepository<Rower,Long> {
}
