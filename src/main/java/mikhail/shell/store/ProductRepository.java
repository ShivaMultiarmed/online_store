package mikhail.shell.store;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ProductRepository<T extends Product> {
    protected final EntityManager entityManager;
    protected Class<T> klass;
    @Autowired
    public ProductRepository(final EntityManagerFactory entityManagerFactory)
    {
        entityManager = entityManagerFactory.createEntityManager();
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
            final List<T> filteredList = productList.stream().filter(product -> product.getProduct_type() == type.getId()).collect(Collectors.toList());
            filteredList.forEach(product -> type.getProducts().add(product));
        });

        return typeList;
    }
    public final T getById(final Long id)
    {
        return entityManager.find(klass, id);
    }
    public final T create(T product)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }
    public final T update(T product)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }
    public final void removeById(final Long id)
    {
        entityManager.getTransaction().begin();
        final T product = getById(id);
        if (product == null)
            return;
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
