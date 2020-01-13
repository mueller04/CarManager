package carmanager.repository;

import carmanager.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends CrudRepository<Car, Long> {

    Optional<Car> findById(Long chassisId);
    List<Car> findAll();
}
