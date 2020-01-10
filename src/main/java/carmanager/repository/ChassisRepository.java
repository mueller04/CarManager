package carmanager.repository;

import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ChassisRepository extends CrudRepository<Chassis, Long> {

    List<Chassis> findByChassisName(String chassisName);
    Optional<Engine> findById(int chassisId);
    List<Chassis> findAll();
}