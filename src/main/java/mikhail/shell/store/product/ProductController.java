package mikhail.shell.store.product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import mikhail.shell.store.product.type.ProductType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
public class ProductController<T extends Product> {
    private final ProductService<T> service;
    @Operation(description = "Endpoint для получения определённого типа товаров по определённым условиям.")
    @GetMapping("")
    public ResponseEntity<List<ProductType>> filterBy(final @RequestParam Map<String, String> params)
    {
        final List<ProductType> filteredList = service.filter(params);
        return new ResponseEntity<>(filteredList, OK);
    }
    @Operation(
            description = "Endpoint для получения товара определённого типа по его идентификатору.",
            responses = {
                    @ApiResponse(description = "Не указан идентификатор товара.", responseCode = "403"),
                    @ApiResponse(description = "Товар не найден.", responseCode = "404"),
                    @ApiResponse(description = "Товар найден.", responseCode = "200")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(final @Parameter(description = "Идентификатор товара") @PathVariable Long id)
    {
        if (id == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else {
            final T product  = service.getById(id);
            return (product != null) ? new ResponseEntity<>(product, OK) : new ResponseEntity<>(NOT_FOUND);
        }
    }
    @Operation(
            description = "Endpoint для создания товара определённого типа.",
            responses = {
                    @ApiResponse(description = "В теле запроса не предоставлен JSON-объект (товар).", responseCode = "403"),
                    @ApiResponse(description = "Товар успешно создан.", responseCode = "201")
            }
    )
    @PostMapping
    public ResponseEntity<T> create(final @Parameter(description = "Создаваемый товар.") @RequestBody T product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.create(product), CREATED);
    }
    @Operation(
            description = "Endpoint для редактирования товара определённого типа.",
            responses = {
                    @ApiResponse(description = "В теле запроса не предоставлен JSON-объект (товар).", responseCode = "403"),
                    @ApiResponse(description = "Товар успешно отредактирован.", responseCode = "200")
            }
    )
    @PutMapping
    public ResponseEntity<T> update(final @RequestBody T product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.update(product), OK);
    }
    @Operation(
            description = "Endpoint для удаления товара определённого типа по его идентификатору.",
            responses = {
                    @ApiResponse(description = "Не указан идентификатор товара.", responseCode = "403"),
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity delete(final @PathVariable Long id)
    {
        if (id == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
        {
            service.removeById(id);
            return new ResponseEntity<>(OK);
        }
    }
}
