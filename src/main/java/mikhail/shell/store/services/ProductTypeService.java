package mikhail.shell.store.services;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.models.ProductType;
import mikhail.shell.store.repositories.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductTypeService implements AbstractService<ProductType> {
    @Autowired
    protected final ProductTypeRepository repository;
    @Override
    public ProductType getById(Long id) {
        return repository.getById(id);
    }
    @Override
    public ProductType create(ProductType productType) {
        return repository.save(productType);
    }
    @Override
    public ProductType update(ProductType productType) {
        return repository.save(productType);
    }
    @Override
    public void removeById(Long id) {
        repository.deleteById(id);
    }
}
