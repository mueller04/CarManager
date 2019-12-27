package carmanager.car;

import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.repository.CarRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CarService {

    final static int BUILD_FEE = 90000;

    @Resource
    private CarRepository repository;

    public void buildCar(Chassis chassis, Engine engine, Tire tire) {

        int price = chassis.getPrice() + engine.getPrice() + tire.getPrice() + BUILD_FEE;

        Car car = Car.builder()
                .carName("prototypeA")
                .price(price)
                .chassis(chassis)
                .engine(engine)
                .tire(tire)
                .build();

        repository.save(car);
    }

    public Car fetchCar() {
        return repository.findByCarName("prototypeA").get(0);
    }

}
