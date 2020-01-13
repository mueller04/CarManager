package carmanager.repository;

import carmanager.entity.Chassis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChassisRepository extends CrudRepository<Chassis, Long> {

    Optional<Chassis> findById(Long chassisId);
    List<Chassis> findAll();
}