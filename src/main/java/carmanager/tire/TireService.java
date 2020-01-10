package carmanager.tire;

import carmanager.entity.Tire;
import carmanager.repository.TireRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TireService {

    @Resource
    private TireRepository repository;

    public void save(String name, int price) {
        repository.save(Tire.builder().tireName(name).price(price).build());
    }

    public Tire fetchTireById(Long id) {
        return repository.findById(id).get();
    }

    public List<Tire> fetchTires() {
        return repository.findAll();
    }
}
