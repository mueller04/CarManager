package carmanager;

import carmanager.car.CarController;
import carmanager.car.CarDAO;
import carmanager.car.CarService;
import carmanager.chassis.ChassisService;
import carmanager.engine.EngineService;
import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.tire.TireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {

    @Resource
    CarService carService;

    @Resource
    ChassisService chassisService;

    @Resource
    EngineService engineService;

    @Resource
    TireService tireService;

    @Resource
    CarController carController;

    @RequestMapping("/")
    String index(Model model){

        List<Car> cars = carService.fetchCars();
        List<Chassis> chassis = chassisService.fetchChassis();
        List<Engine> engines = engineService.fetchEngines();
        List<Tire> tires = tireService.fetchTires();

        model.addAttribute("cars", cars);
        model.addAttribute("chassis", chassis);
        model.addAttribute("engines", engines);
        model.addAttribute("tires", tires);
        return "index";
    }

    @RequestMapping("/createChassis")
    String createChassis() {
        return "createChassis";
    }

    @RequestMapping("/createEngine")
    String createEngine() {
        return "createEngine";
    }

    @RequestMapping("/createTire")
    String createTire() {
        return "createTire";
    }

    @RequestMapping("/viewCar")
    String viewCar(Model model) {
        List<Car> cars = carService.fetchCars();
        model.addAttribute("cars", cars);
        return "viewCar";
    }

    @RequestMapping("fetchCarDetails")
    String fetchCarDetails(@RequestParam("carId") Long carId, Model model) {
        CarDAO carDAO = carController.fetchCar(carId);
        List<Car> cars = carService.fetchCars();
        model.addAttribute("carDAO", carDAO);
        model.addAttribute("cars", cars);
        return "viewCar";
    }
}
