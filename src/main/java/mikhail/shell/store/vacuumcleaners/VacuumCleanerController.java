package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.ProductController;
import mikhail.shell.store.smartphones.SmartPhone;
import mikhail.shell.store.smartphones.SmartphoneService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/smartphones")
public class VacuumCleanerController extends ProductController<VacuumCleaner, VacuumCleanerService> {
    public VacuumCleanerController(final VacuumCleanerService service) {
        super(service);
    }
}