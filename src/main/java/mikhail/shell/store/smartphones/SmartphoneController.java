package mikhail.shell.store.smartphones;

import io.swagger.v3.oas.annotations.tags.Tag;
import mikhail.shell.store.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Смартфоны")
@RestController
@RequestMapping("/api/smartphones")
public class SmartphoneController extends ProductController<SmartPhone> {
    @Autowired
    public SmartphoneController(final SmartphoneService service) {
        super(service);
    }
}
