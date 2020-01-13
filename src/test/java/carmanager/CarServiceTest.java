
package carmanager;

import carmanager.car.CarService;
import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    CarService carService;

    @Test
    public void testBuildCar() {
        Chassis chassis = Chassis.builder().price(10).build();
        Engine engine = Engine.builder().price(6).build();
        Tire tire = Tire.builder().price(2).build();

        int buildFee = 90000;
        int expectedPrice = 18 + buildFee;

        carService.buildCar("prototypeA", chassis, engine, tire);

        Car expectedCar = Car.builder()
                .carName("prototypeA")
                .chassis(chassis)
                .engine(engine)
                .price(expectedPrice)
                .tire(tire)
                .build();
        verify(carRepository).save(expectedCar);
    }
}