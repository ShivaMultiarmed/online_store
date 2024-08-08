package mikhail.shell.store.smartphones;

import mikhail.shell.store.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/smartphones")
public class SmartphoneController extends ProductController<SmartPhone> {
    @Autowired
    public SmartphoneController(final SmartphoneService service) {
        super(service);
    }
}
