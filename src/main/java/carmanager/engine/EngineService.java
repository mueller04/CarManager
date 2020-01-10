package carmanager.engine;

import carmanager.entity.Chassis;
import carmanager.entity.Engine;
import carmanager.repository.EngineRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EngineService {

    @Resource
    private EngineRepository repository;

    public void save(String name, int price) {
        repository.save(Engine.builder().engineName(name).price(price).build());
    }

    public Engine fetchEngineById(Long id) {
        return repository.findById(id).get();
    }

    public List<Engine> fetchEngines() {
        return repository.findAll();
    }

}
