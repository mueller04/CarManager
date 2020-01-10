package carmanager.engine;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EngineController {

    @Resource
    EngineService engineService;

    @RequestMapping("/engine")
    public void createEngine(@RequestParam("engineName") String engineName, @RequestParam("price") String price) {
        engineService.save(engineName, Integer.valueOf(price));
    }
}
