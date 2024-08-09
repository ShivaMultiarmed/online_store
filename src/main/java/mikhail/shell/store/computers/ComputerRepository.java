package mikhail.shell.store.computers;

import mikhail.shell.store.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class ComputerRepository extends ProductRepository<Computer> {
    @Autowired
    public ComputerRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = Computer.class;
    }
}