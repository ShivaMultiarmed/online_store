package mikhail.shell.store;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductService<T extends Product> {
    protected final ProductRepository<T> repository;
    protected final String typeName;
    public List<ProductType> filter(final Map<String, String> params)
    {
        final StoreQueryBuilder<ProductType> typeFilter = repository.filterType().equal("name", typeName);
        final StoreQueryBuilder<T> productFilter = repository.filterProduct();
        if (params.containsKey("maxPrice"))
            productFilter.lessOrEqual("price", Double.parseDouble(params.get("maxPrice")));
        return repository.collect(typeFilter, productFilter);
    }
    public T getById(final Long id)
    {
       return repository.getById(id);
    }
    public T create(final T product)
    {
        return repository.create(product);
    }
    public T update(final T product)
    {
        return repository.update(product);
    }
    public void removeById(final Long id)
    {
        repository.removeById(id);
    }
}
