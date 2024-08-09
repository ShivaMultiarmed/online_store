package mikhail.shell.store.product.type;

import mikhail.shell.store.base.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product_types")
public class ProductTypeController extends AbstractController<ProductType, ProductTypeRepository, ProductTypeService> {
    @Autowired
    public ProductTypeController(ProductTypeService service) {
        super(service);
    }
}
