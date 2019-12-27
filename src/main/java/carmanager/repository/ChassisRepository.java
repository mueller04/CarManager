package carmanager.repository;

import carmanager.entity.Chassis;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChassisRepository extends CrudRepository<Chassis, Long> {

    List<Chassis> findByChassisName(String chassisName);

}