package carmanager.tire;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TireController {

    @Resource
    TireService tireService;

    @RequestMapping("/tire")
    public void createTire(@RequestParam("tireName") String tireName, @RequestParam("price") String price) {
        tireService.save(tireName, Integer.valueOf(price));
    }
}
