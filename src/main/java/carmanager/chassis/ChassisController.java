package carmanager.chassis;

import carmanager.entity.Chassis;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("/chassis")
public class ChassisController {

    @Resource
    ChassisService chassisService;

    @GetMapping()
    public Chassis fetchChassis() {
        return chassisService.fetchChassisByName("HA");
    }

    @PostMapping()
    public void createChassis(@RequestParam("chassisName") String chassisName, @RequestParam("price") String price) {
        chassisService.save(chassisName, Integer.valueOf(price));
    }
}