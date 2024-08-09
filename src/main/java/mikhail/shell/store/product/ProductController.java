package mikhail.shell.store.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import mikhail.shell.store.base.AbstractController;
import mikhail.shell.store.product.type.ProductType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

public abstract class ProductController<T extends Product> extends AbstractController<T, ProductRepository<T>, ProductService<T>> {
    public ProductController(ProductService<T> service) {
        super(service);
    }
    @Operation(
            description = "Endpoint для получения определённого типа товаров по определённым условиям."
    )
    @Parameters({
            @Parameter(name = "maxPrice", description = "Максимальная стоимость."),
            @Parameter(name = "minPrice", description = "Минимальная стоимость."),
            @Parameter(name = "manufacturer", description = "Фирма-производитель."),
            @Parameter(name = "color", description = "Цвет"),
            @Parameter(name = "name", description = "модель"),
            @Parameter(name = "technology", description = "технология"),
            @Parameter(name = "doors", description = "количество дверей"),
            @Parameter(name = "cameras", description = "кол-во камер"),
            @Parameter(name = "memory", description = "объём памяти"),
            @Parameter(name = "processor", description = "тип процессора"),
            @Parameter(name = "volume", description = "объём пылесоса"),
            @Parameter(name = "modes", description = "количество режимов"),
            @Parameter(name = "compressor", description = "тип компрессора")
    })
    @GetMapping("")
    public ResponseEntity<List<ProductType>> filterBy(
            final
            @RequestParam Map<String, String> params
    )
    {
        final List<ProductType> filteredList = service.filter(params);
        return new ResponseEntity<>(filteredList, OK);
    }
}
