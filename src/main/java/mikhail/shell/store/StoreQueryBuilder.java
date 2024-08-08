package mikhail.shell.store;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class StoreQueryBuilder<T extends Product> {
    private final CriteriaBuilder cb;
    private final CriteriaQuery<ProductType> criteriaQuery;
    private final Root<ProductType> productTypeRoot;
    private final Join<ProductType, T> joinedProduct;
    private final List<Predicate> predicates = new ArrayList<>();
    public StoreQueryBuilder(final CriteriaBuilder cb, final Class<T> klass)
    {
        this.cb = cb;
        criteriaQuery = cb.createQuery(ProductType.class);
        productTypeRoot = criteriaQuery.from(ProductType.class);
        joinedProduct = productTypeRoot.join("products");
    }
    public StoreQueryBuilder<T> rootEquals(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.equal(productTypeRoot.get(field), value));
        return this;
    }
    public StoreQueryBuilder<T> rootLike(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.like(productTypeRoot.get(field), "%" + value + "%"));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> rootLessOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.lessThanOrEqualTo(productTypeRoot.get(field), value));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> rootGreaterOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.greaterThanOrEqualTo(productTypeRoot.get(field), value));
        return this;
    }
    public StoreQueryBuilder<T> joinEquals(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.equal(joinedProduct.get(field), value));
        return this;
    }
    public StoreQueryBuilder<T> joinLike(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.like(joinedProduct.get(field), "%" + value + "%"));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> joinLessOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.lessThanOrEqualTo(joinedProduct.get(field), value));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> joinGreaterOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.greaterThanOrEqualTo(joinedProduct.get(field), value));
        return this;
    }
    public CriteriaQuery<ProductType> build()
    {
        return criteriaQuery.select(productTypeRoot)
                .where(cb.and(predicates.toArray(new Predicate[0])))
                .distinct(true);
    }
}
