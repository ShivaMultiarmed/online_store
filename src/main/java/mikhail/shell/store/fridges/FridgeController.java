package mikhail.shell.store.fridges;

import io.swagger.v3.oas.annotations.tags.Tag;
import mikhail.shell.store.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Холодильники")
@RestController
@RequestMapping("/api/fridges")
public class FridgeController extends ProductController<Fridge> {
    @Autowired
    public FridgeController(final FridgeService service) {
        super(service);
    }
}