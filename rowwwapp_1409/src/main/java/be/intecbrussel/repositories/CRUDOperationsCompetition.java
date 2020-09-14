package be.intecbrussel.repositories;

import be.intecbrussel.models.competition.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDOperationsCompetition extends CrudRepository<Competition,Long> {
    /**
    *All the methods are available in the CrudRepository<Competition,Long> interface.
    *I just have to select which one I need to override to do so if needed.
    *Spring Data JPA creates an implementation of CrudOperationsCompetition when I run the application.
     **/
}
