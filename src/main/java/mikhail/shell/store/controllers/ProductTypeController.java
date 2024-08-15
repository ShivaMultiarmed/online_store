package mikhail.shell.store.controllers;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.services.AbstractService;
import mikhail.shell.store.models.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product_types")
@RequiredArgsConstructor
public class ProductTypeController implements AbstractController<ProductType> {
    @Autowired
    private final AbstractService<ProductType> service;
    @Override
    public ResponseEntity<ProductType> getById(Long id) {
        return null;
    }
    @Override
    public ResponseEntity<ProductType> create(ProductType product) {
        return null;
    }
    @Override
    public ResponseEntity<ProductType> update(ProductType product) {
        return null;
    }
    @Override
    public ResponseEntity<String> delete(Long id) {
        return null;
    }
}
