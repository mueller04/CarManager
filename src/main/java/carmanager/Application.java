package carmanager;

import carmanager.car.CarService;
import carmanager.chassis.ChassisService;
import carmanager.engine.EngineService;
import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.entity.Tire;
import carmanager.tire.TireService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
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
            Chassis chassis = Chassis.builder().chassisName("HX").price(180000).build();

            Engine engine = Engine.builder().engineName("F20").price(140000).build();
            engineService.save("J30", 170000);

            Tire tire = Tire.builder().tireName("Slick").price(50000).build();
            tireService.save("Rain", 75000);
            tireService.save("Intermediate", 65000);

            carService.buildCar(chassis, engine, tire);
        });
    }
}
