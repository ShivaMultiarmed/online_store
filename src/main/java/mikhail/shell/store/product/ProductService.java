package mikhail.shell.store.product;

import mikhail.shell.store.base.AbstractService;
import mikhail.shell.store.product.type.ProductType;
import mikhail.shell.store.db.StoreQueryBuilder;

import java.util.List;
import java.util.Map;

public abstract class ProductService<T extends Product> extends AbstractService<T, ProductRepository<T>> {
    protected final String typeName;
    public ProductService(ProductRepository<T> repository, String typeName) {
        super(repository);
        this.typeName = typeName;
    }
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
}
