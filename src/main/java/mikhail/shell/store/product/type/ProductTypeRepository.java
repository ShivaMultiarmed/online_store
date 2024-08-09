package mikhail.shell.store.product.type;

import mikhail.shell.store.base.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class ProductTypeRepository extends AbstractRepository<ProductType> {
    @Autowired
    public ProductTypeRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
        klass = ProductType.class;
    }
}
