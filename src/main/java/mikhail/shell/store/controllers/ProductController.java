package mikhail.shell.store.controllers;


import lombok.RequiredArgsConstructor;
import mikhail.shell.store.services.AbstractService;
import mikhail.shell.store.models.Product;
import mikhail.shell.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController implements AbstractController<Product> {
    @Autowired
    private final ProductService service;
    /*public ResponseEntity<List<ProductType>> filterBy(final @RequestParam Map<String, String> params)
    {
        final List<ProductType> filteredList = service.filter(params);
        return new ResponseEntity<>(filteredList, OK);
    }*/
    @Override
    public ResponseEntity<Product> getById(final Long id)
    {
        if (id == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else {
            final Product product  = service.getById(id);
            return (product != null) ? new ResponseEntity<>(product, OK) : new ResponseEntity<>(NOT_FOUND);
        }
    }
    @Override
    public ResponseEntity<Product> create(final Product product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.create(product), CREATED);
    }
    @Override
    public ResponseEntity<Product> update(final Product product)
    {
        if (product == null)
            return new ResponseEntity<>(BAD_REQUEST);
        else
            return new ResponseEntity<>(service.update(product), OK);
    }
    @Override
    public ResponseEntity<String> delete(final Long id)
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
