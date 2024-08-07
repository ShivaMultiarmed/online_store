package mikhail.shell.store.tvs;

import mikhail.shell.store.ProductRepository;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class TVRepository extends ProductRepository<TV> {
    @Autowired
    public TVRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = TV.class;
    }
}