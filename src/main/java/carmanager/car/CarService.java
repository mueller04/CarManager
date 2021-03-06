package carmanager.car;

import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarService {

    final static int BUILD_FEE = 90000;

    @Resource
    private CarRepository repository;

    public void buildCar(String carName, Chassis chassis, Engine engine, Tire tire) {

        int price = chassis.getPrice() + engine.getPrice() + tire.getPrice() + BUILD_FEE;

        Car car = Car.builder()
                .carName(carName)
                .price(price)
                .chassisId(chassis.getId())
                .engineId(engine.getId())
                .tireId(tire.getId())
                .build();

        repository.save(car);
    }

    public Car fetchCarById(Long id) {
        return repository.findById(id).get();
    }

    public List<Car> fetchCars() {
        return repository.findAll();
    }
}
