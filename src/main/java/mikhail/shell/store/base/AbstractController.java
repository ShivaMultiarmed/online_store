package mikhail.shell.store.base;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
public class AbstractController<T, K extends AbstractRepository<T>, V extends AbstractService<T, K>> {
    protected final V service;
    @Operation(
            description = "Endpoint для получения товара определённого типа по его идентификатору.",
            responses = {
                    @ApiResponse(description = "Не указан идентификатор товара.", responseCode = "403"),
                    @ApiResponse(description = "Товар не найден.", responseCode = "404"),
                    @ApiResponse(description = "Товар найден.", responseCode = "200")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(final @Parameter(description = "Идентификатор объекта", required = true) @PathVariable Long id)
    {
        if (id == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else {
            final T product  = service.getById(id);
            return (product != null) ? new ResponseEntity<>(product, OK) : new ResponseEntity<>(NOT_FOUND);
        }
    }
    @Operation(
            description = "Endpoint для создания объекта определённого типа.",
            responses = {
                    @ApiResponse(description = "В теле запроса не предоставлен JSON-объект.", responseCode = "403"),
                    @ApiResponse(description = "объект успешно создан.", responseCode = "201")
            }
    )
    @PostMapping
    public ResponseEntity<T> create(final @Parameter(description = "Создаваемый объект.") @RequestBody T product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.create(product), CREATED);
    }
    @Operation(
            description = "Endpoint для редактирования объекта определённого типа.",
            responses = {
                    @ApiResponse(description = "В теле запроса не предоставлен JSON-объект.", responseCode = "403"),
                    @ApiResponse(description = "объект успешно отредактирован.", responseCode = "200")
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
            description = "Endpoint для удаления объекта определённого типа по его идентификатору.",
            responses = {
                    @ApiResponse(description = "Не указан идентификатор объекта.", responseCode = "403"),
                    @ApiResponse(description = "объект удалён.", responseCode = "200")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity delete(final @Parameter(description = "Идентификатор объекта.", required = true) @PathVariable Long id)
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
