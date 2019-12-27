package carmanager.engine;

import carmanager.entity.Engine;
import carmanager.repository.EngineRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EngineService {

    @Resource
    private EngineRepository repository;

    public void save(String name, int price) {
        repository.save(Engine.builder().engineName(name).price(price).build());
    }

}
