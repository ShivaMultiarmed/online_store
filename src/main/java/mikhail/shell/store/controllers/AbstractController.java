package mikhail.shell.store.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

//@RequestMapping("/default")
public interface AbstractController<T extends Serializable>
{
    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<T> getById(final @PathVariable Long id);
    @PostMapping(produces = "application/json",consumes = "application/json")
    ResponseEntity<T> create(final @RequestBody T product);
    @PutMapping(produces = "application/json",consumes = "application/json")
    ResponseEntity<T> update(final @RequestBody T product);
    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(final @PathVariable Long id);
}