package carmanager.repository;

import carmanager.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findAll();

    List<Car> findByCarName(String carName);


}
