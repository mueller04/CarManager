package carmanager.repository;

import carmanager.entity.Tire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TireRepository extends CrudRepository<Tire, Long> {

    List<Tire> findByTireName(String tireName);
    Optional<Tire> findById(Long tireId);
    List<Tire> findAll();
}
