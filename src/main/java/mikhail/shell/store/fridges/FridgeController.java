package mikhail.shell.store.fridges;

import mikhail.shell.store.ProductController;
import mikhail.shell.store.smartphones.SmartPhone;
import mikhail.shell.store.smartphones.SmartphoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/smartphones")
public class FridgeController extends ProductController<Fridge, FridgeService> {
    public FridgeController(final FridgeService service) {
        super(service);
    }
}