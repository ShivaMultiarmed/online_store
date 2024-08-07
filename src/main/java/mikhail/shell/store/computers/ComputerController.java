package mikhail.shell.store.computers;

import mikhail.shell.store.ProductController;
import mikhail.shell.store.smartphones.SmartPhone;
import mikhail.shell.store.smartphones.SmartphoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/smartphones")
public class ComputerController extends ProductController<Computer, ComputerService> {
    public ComputerController(final ComputerService service) {
        super(service);
    }
}