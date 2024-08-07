package mikhail.shell.store.smartphones;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.ProductService;
import org.springframework.stereotype.Service;

@Service
public class SmartphoneService extends ProductService<SmartPhone> {
    public SmartphoneService(final SmartphoneRepository repository) {
        super(repository);
    }
}
