package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacuumCleanerService extends ProductService<VacuumCleaner> {
    @Autowired
    public VacuumCleanerService(final VacuumCleanerRepository repository) {
        super(repository);
    }
}