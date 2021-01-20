package be.intecbrussel.repositories;

import be.intecbrussel.models.registration.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDOperationsTeam extends CrudRepository<Team,Long> {
}
