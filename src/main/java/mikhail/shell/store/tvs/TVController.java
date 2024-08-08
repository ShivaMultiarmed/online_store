package mikhail.shell.store.tvs;

import mikhail.shell.store.ProductController;
import mikhail.shell.store.smartphones.SmartPhone;
import mikhail.shell.store.smartphones.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/tvs")
public class TVController extends ProductController<TV> {
    @Autowired
    public TVController(final TVService service) {
        super(service);
    }
}