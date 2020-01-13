package carmanager.car;

import carmanager.chassis.ChassisService;
import carmanager.engine.EngineService;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.tire.TireService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@RestController
public class CarController {

    @Resource
    CarService carService;

    @Resource
    ChassisService chassisService;

    @Resource
    EngineService engineService;

    @Resource
    TireService tireService;

    @Resource
    EntityManager entityManager;

    @PostMapping("/createCar")
    public void createCar(@RequestParam("carName") String carName,
                          @RequestParam("chassisId") Long chassisId,
                          @RequestParam("engineId") Long engineId,
                          @RequestParam("tireId") Long tireId) {
        Chassis chassis = chassisService.fetchChassisById(chassisId);
        Engine engine = engineService.fetchEngineById(engineId);
        Tire tire = tireService.fetchTireById(tireId);

        carService.buildCar(carName, chassis, engine, tire);
    }
}
