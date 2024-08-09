package mikhail.shell.store.vacuumcleaners;

import io.swagger.v3.oas.annotations.tags.Tag;
import mikhail.shell.store.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Пылесосы")
@RestController
@RequestMapping("/api/vacuum_cleaners")
public class VacuumCleanerController extends ProductController<VacuumCleaner> {
    @Autowired
    public VacuumCleanerController(final VacuumCleanerService service) {
        super(service);
    }
}