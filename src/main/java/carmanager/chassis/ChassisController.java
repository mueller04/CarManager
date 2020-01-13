package carmanager.chassis;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ChassisController {

    @Resource
    ChassisService chassisService;

    @PostMapping("/chassis")
    public void createChassis(@RequestParam("chassisName") String chassisName, @RequestParam("price") String price) {
        chassisService.save(chassisName, Integer.valueOf(price));
    }
}