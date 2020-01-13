package carmanager.tire;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TireController {

    @Resource
    TireService tireService;

    @PostMapping("/tire")
    public void createTire(@RequestParam("tireName") String tireName, @RequestParam("price") String price) {
        tireService.save(tireName, Integer.valueOf(price));
    }
}
