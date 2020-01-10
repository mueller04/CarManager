package carmanager.repository;

import carmanager.entity.Engine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EngineRepository extends CrudRepository<Engine, Long> {

    List<Engine> findByEngineName(String engineName);
    Optional<Engine> findById(Long engineId);
    List<Engine> findAll();
}
