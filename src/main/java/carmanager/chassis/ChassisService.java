package carmanager.chassis;

import carmanager.entity.Chassis;
import carmanager.repository.ChassisRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChassisService {

    @Resource
    private ChassisRepository repository;

    public Chassis fetchChassisById(Long id) {
        return repository.findById(id).get();
    }

    public Chassis save(String name, int price) {
        return repository.save(Chassis.builder().chassisName(name).price(price).build());
    }

    public List<Chassis> fetchChassis() {
        return repository.findAll();
    }


}
