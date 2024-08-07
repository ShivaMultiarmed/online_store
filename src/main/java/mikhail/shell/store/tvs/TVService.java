package mikhail.shell.store.tvs;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.stereotype.Service;

@Service
public class TVService extends ProductService<TV> {
    public TVService(final TVRepository repository) {
        super(repository);
    }
}