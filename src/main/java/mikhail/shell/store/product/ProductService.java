package mikhail.shell.store.product;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.product.type.ProductType;
import mikhail.shell.store.db.StoreQueryBuilder;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public abstract class ProductService<T extends Product> {
    protected final ProductRepository<T> repository;
    protected final String typeName;
    public final List<ProductType> filter(final Map<String, String> params)
    {
        final StoreQueryBuilder<ProductType> typeFilter = createTypeFilter(params);
        final StoreQueryBuilder<T> productFilter = createProductFilter(params);
        return repository.collect(typeFilter, productFilter);
    }
    private StoreQueryBuilder<ProductType> createTypeFilter(final Map<String, String> params)
    {
        final StoreQueryBuilder<ProductType> filter = repository.filterType().equal("name", typeName);
        if (params.containsKey("manufacturer"))
            filter.equal("manufacturer", params.get("manufacturer"));
        return filter;
    }
    private StoreQueryBuilder<T> createProductFilter(final Map<String, String> params)
    {
        final StoreQueryBuilder<T> filter = repository.filterProduct();
        if (params.containsKey("name"))
            filter.like("name", params.get("name"));
        if (params.containsKey("color"))
            filter.equal("color", params.get("color"));
        if (params.containsKey("maxPrice"))
            filter.lessOrEqual("price", Double.parseDouble(params.get("maxPrice")));
        if (params.containsKey("minPrice"))
            filter.greaterOrEqual("price", Double.parseDouble(params.get("minPrice")));
        return createSpecificProductFilter(params, filter);
    }
    protected abstract StoreQueryBuilder<T> createSpecificProductFilter(final Map<String, String> params, final StoreQueryBuilder<T> filter);
    //protected abstract StoreQueryBuilder<T> createProductFilter(final Map<String, String> params);
    public final T getById(final Long id)
    {
       return repository.getById(id);
    }
    public final T create(final T product)
    {
        return repository.create(product);
    }
    public final T update(final T product)
    {
        return repository.update(product);
    }
    public final void removeById(final Long id)
    {
        repository.removeById(id);
    }
}
