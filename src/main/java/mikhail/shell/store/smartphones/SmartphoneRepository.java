package mikhail.shell.store.smartphones;


import mikhail.shell.store.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class SmartphoneRepository extends ProductRepository<SmartPhone> {
    @Autowired
    public SmartphoneRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = SmartPhone.class;
    }
}