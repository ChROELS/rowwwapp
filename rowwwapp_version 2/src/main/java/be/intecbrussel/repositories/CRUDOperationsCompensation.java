package be.intecbrussel.repositories;

import be.intecbrussel.models.competition.Compensation;
import org.springframework.data.repository.CrudRepository;

public interface CRUDOperationsCompensation extends CrudRepository<Compensation,Long> {
}
