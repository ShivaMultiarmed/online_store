package mikhail.shell.store.computers;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComputerService extends ProductService<Computer> {
    @Autowired
    public ComputerService(final ComputerRepository repository) {
        super(repository);
    }
}