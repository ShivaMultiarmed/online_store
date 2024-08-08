package mikhail.shell.store.computers;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.fridges.Fridge;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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