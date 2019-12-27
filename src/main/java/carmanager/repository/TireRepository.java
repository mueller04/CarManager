package carmanager.repository;

import carmanager.entity.Tire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TireRepository extends CrudRepository<Tire, Long> {

    List<Tire> findByTireName(String tireName);
}
