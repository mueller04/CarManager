package carmanager.chassis;

import carmanager.entity.Chassis;
import carmanager.repository.CarRepository;
import carmanager.repository.ChassisRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChassisService {

    @Resource
    private ChassisRepository repository;

    public Chassis fetchChassisByName(String name) {
        return repository.findByChassisName(name).get(0);
    }

    public void save(String name, int price) {
        repository.save(Chassis.builder().chassisName(name).price(price).build());
    }

}
