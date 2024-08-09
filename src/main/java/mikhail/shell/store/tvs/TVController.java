package mikhail.shell.store.tvs;

import io.swagger.v3.oas.annotations.tags.Tag;
import mikhail.shell.store.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Телевизоры")
@RestController
@RequestMapping("/api/tvs")
public class TVController extends ProductController<TV> {
    @Autowired
    public TVController(final TVService service) {
        super(service);
    }
}