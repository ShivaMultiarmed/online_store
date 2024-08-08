package mikhail.shell.store.fridges;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FridgeService extends ProductService<Fridge> {
    @Autowired
    public FridgeService(final FridgeRepository repository) {
        super(repository);
    }
}