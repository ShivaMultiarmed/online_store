package mikhail.shell.store.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StoreQueryBuilder<T> {
    private final CriteriaBuilder cb;
    private final CriteriaQuery<T> criteriaQuery;
    private final Root<T> root;
    private final List<Predicate> predicates = new ArrayList<>();
    public StoreQueryBuilder(final CriteriaBuilder cb, final Class<T> klass)
    {
        this.cb = cb;
        criteriaQuery = cb.createQuery(klass);
        root = criteriaQuery.from(klass);
    }
    public StoreQueryBuilder<T> in(final String field, final List<Long> values)
    {
        if (values != null)
            predicates.add(root.get(field).in(values));
        return this;
    }
    public StoreQueryBuilder<T> equal(final String field, final Object value)
    {
        if (value != null)
            predicates.add(cb.equal(root.get(field), value));
        return this;
    }
    public StoreQueryBuilder<T> like(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.like(root.get(field), "%" + value + "%"));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> lessOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.lessThanOrEqualTo(root.get(field), value));
        return this;
    }
    public <V extends Comparable<? super V>> StoreQueryBuilder<T> greaterOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.greaterThanOrEqualTo(root.get(field), value));
        return this;
    }
    public CriteriaQuery<T> build()
    {
        return criteriaQuery.select(root).where(cb.and(predicates.toArray(new Predicate[0]))).distinct(true);
    }
}
