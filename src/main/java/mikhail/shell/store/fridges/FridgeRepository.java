package mikhail.shell.store.fridges;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class FridgeRepository extends ProductRepository<Fridge> {
    @Autowired
    public FridgeRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = Fridge.class;
    }
}