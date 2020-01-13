package carmanager;

import carmanager.car.CarService;
import carmanager.chassis.ChassisService;
import carmanager.engine.EngineService;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.tire.TireService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner seedData(EngineService engineService,
                                      TireService tireService,
                                      CarService carService,
                                      ChassisService chassisService) {
        return (args -> {
            chassisService.save("HW", 250000);
            engineService.save("J30", 170000);
            tireService.save("Rain", 75000);
            tireService.save("Intermediate", 65000);

            Chassis chassis = Chassis.builder().chassisName("HX").price(180000).build();
            chassis = chassisService.save(chassis.getChassisName(), chassis.getPrice());
            Engine engine = Engine.builder().engineName("F20").price(140000).build();
            engine = engineService.save(engine.getEngineName(), engine.getPrice());
            Tire tire = Tire.builder().tireName("Slick").price(50000).build();
            tire = tireService.save(tire.getTireName(), tire.getPrice());
            carService.buildCar("PrototypeA", chassis, engine, tire);

            Chassis chassis2 = Chassis.builder().chassisName("AX").price(250000).build();
            chassis2 = chassisService.save(chassis2.getChassisName(), chassis2.getPrice());
            Engine engine2 = Engine.builder().engineName("W80").price(140000).build();
            engine2 = engineService.save(engine2.getEngineName(), engine2.getPrice());
            Tire tire2 = Tire.builder().tireName("Rain").price(50000).build();
            tire2 = tireService.save(tire2.getTireName(), tire2.getPrice());
            carService.buildCar("PrototypeB", chassis2, engine2, tire2);
        });
    }
}
