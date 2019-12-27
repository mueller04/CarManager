package carmanager.repository;

import carmanager.entity.Engine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EngineRepository extends CrudRepository<Engine, Long> {

    List<Engine> findByEngineName(String engineName);
}
