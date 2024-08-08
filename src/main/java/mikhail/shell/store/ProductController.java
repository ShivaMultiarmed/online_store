package mikhail.shell.store;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
public class ProductController<T extends Product> {
    private final ProductService<T> service;
    @GetMapping("")
    public ResponseEntity<List<T>> filterBy(final @RequestParam Map<String, String> params)
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
    @PostMapping
    public ResponseEntity<T> create(final @RequestBody T product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.create(product), OK);
    }
}
