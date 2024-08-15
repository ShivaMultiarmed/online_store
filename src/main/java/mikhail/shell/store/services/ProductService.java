package mikhail.shell.store.services;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.models.Product;
import mikhail.shell.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sun.reflect.generics.repository.AbstractRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService implements AbstractService<Product> {
    @Autowired
    private final ProductRepository repository;
    @Override
    public Product getById(Long id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public Product create(Product product) {
        return repository.save(product);
    }
    @Override
    public Product update(Product product) {
        return repository.save(product);
    }
    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
