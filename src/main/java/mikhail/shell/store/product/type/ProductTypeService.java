package mikhail.shell.store.product.type;

import mikhail.shell.store.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeService extends AbstractService<ProductType, ProductTypeRepository> {
    @Autowired
    public ProductTypeService(ProductTypeRepository repository) {
        super(repository);
    }
}
