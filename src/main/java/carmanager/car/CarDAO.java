package carmanager.car;

import carmanager.entity.Car;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDAO {

    Car car;
    Chassis chassis;
    Engine engine;
    Tire tire;

}
