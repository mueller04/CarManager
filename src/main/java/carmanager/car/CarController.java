package carmanager.car;

import carmanager.chassis.ChassisService;
import carmanager.engine.EngineService;
import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.tire.TireService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
