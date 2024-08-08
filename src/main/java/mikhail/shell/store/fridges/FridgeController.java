package mikhail.shell.store.fridges;

import mikhail.shell.store.ProductController;
import mikhail.shell.store.smartphones.SmartPhone;
import mikhail.shell.store.smartphones.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/fridges")
public class FridgeController extends ProductController<Fridge> {
    @Autowired
    public FridgeController(final FridgeService service) {
        super(service);
    }
}