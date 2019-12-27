package carmanager.car;

import carmanager.entity.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CarController {

    @Resource
    CarService carService;

    @RequestMapping("/")
    public String car() {
        Car carEntity = carService.fetchCar();
        return CarResponse.builder().carName(carEntity.getCarName()).price(carEntity.getPrice()).build().toString();
    }
}
