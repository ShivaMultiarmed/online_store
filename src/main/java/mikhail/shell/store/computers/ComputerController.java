package mikhail.shell.store.computers;

import io.swagger.v3.oas.annotations.tags.Tag;
import mikhail.shell.store.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Компьютеры")
@RestController
@RequestMapping("/api/computers")
public class ComputerController extends ProductController<Computer> {
    @Autowired
    public ComputerController(final ComputerService service) {
        super(service);
    }
}