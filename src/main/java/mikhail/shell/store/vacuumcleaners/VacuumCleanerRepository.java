package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class VacuumCleanerRepository extends ProductRepository<VacuumCleaner> {
    @Autowired
    public VacuumCleanerRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = VacuumCleaner.class;
    }
}