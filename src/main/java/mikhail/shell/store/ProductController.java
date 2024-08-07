package mikhail.shell.store;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

public class ProductController<T extends Product, K extends ProductService<T>> extends TypeToken<T> {
    @Autowired
    private final K service;
    public ProductController(final K service)
    {
        this.service = service;
    }
    @GetMapping("/")
    public ResponseEntity<List<T>> filterBy(final @NotNull @RequestParam Map<String, String> params)
    {
        final List<T> filteredList = service.filter(params);
        return new ResponseEntity<>(filteredList, OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(final @PathVariable Long id)
    {
        if (id == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else {
            final T product  = service.getById(id);
            return (product != null) ? new ResponseEntity<>(product, OK) : new ResponseEntity<>(NOT_FOUND);
        }
    }
}
