package mikhail.shell.store.product;

import lombok.extern.slf4j.Slf4j;
import mikhail.shell.store.base.AbstractRepository;
import mikhail.shell.store.product.type.ProductType;
import mikhail.shell.store.db.StoreQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class ProductRepository<T extends Product> extends AbstractRepository<T> {
    @Autowired
    public ProductRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
    }
    public final StoreQueryBuilder<ProductType> filterType()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return new StoreQueryBuilder<>(cb, ProductType.class);
    }
    public final StoreQueryBuilder<T> filterProduct()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return new StoreQueryBuilder<>(cb, klass);
    }
    public final List<ProductType> collect(final StoreQueryBuilder<ProductType> typeBuilder, final StoreQueryBuilder<T> productBuilder)
    {
        final CriteriaQuery<ProductType> typeQuery = typeBuilder.build();
        final List<ProductType> typeList = entityManager.createQuery(typeQuery).getResultList();
        final List<Long> typeIdList = typeList.stream().map(ProductType::getId).collect(Collectors.toList());
        final CriteriaQuery<T> productQuery = productBuilder.in("product_type", typeIdList).build();
        final List<T> productList = entityManager.createQuery(productQuery).getResultList();

        typeList.forEach(type -> {
            type.getProducts().clear();
            final List<T> filteredList = productList
                    .stream().
                    filter(product -> product.getProduct_type() == type.getId()).
                    collect(Collectors.toList());
            filteredList.forEach(product -> {
                type.getProducts().add(product);
            });
        });

        return typeList;
    }
}
