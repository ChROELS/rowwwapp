package be.intecbrussel.repositories;

import be.intecbrussel.models.competition.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDOperationsCompetition extends CrudRepository<Competition,Long> {
}

