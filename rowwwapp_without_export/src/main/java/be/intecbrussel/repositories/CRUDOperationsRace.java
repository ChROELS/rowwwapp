package be.intecbrussel.repositories;

import be.intecbrussel.models.competition.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDOperationsRace extends CrudRepository<Race,Long> {
    @Override
    Iterable<Race> findAll();
}
