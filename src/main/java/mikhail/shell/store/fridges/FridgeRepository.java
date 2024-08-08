package mikhail.shell.store.fridges;

import lombok.extern.slf4j.Slf4j;
import mikhail.shell.store.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Component
@Slf4j
public class FridgeRepository extends ProductRepository<Fridge> {
    @Autowired
    public FridgeRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = Fridge.class;
    }
}