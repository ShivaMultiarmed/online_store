package mikhail.shell.store.smartphones;


import mikhail.shell.store.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class SmartphoneRepository extends ProductRepository<SmartPhone> {
    @Autowired
    public SmartphoneRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = SmartPhone.class;
    }
}