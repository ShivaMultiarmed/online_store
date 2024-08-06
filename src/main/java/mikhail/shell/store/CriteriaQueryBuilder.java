package mikhail.shell.store;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.fridges.Fridge;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CriteriaQueryBuilder <T extends Product> {
    private final CriteriaBuilder cb;
    private final CriteriaQuery<T> criteriaQuery;
    private final Root<T> root;
    private final List<Predicate> predicates = new ArrayList<>();
    public CriteriaQueryBuilder(final CriteriaBuilder cb, final Class<T> klass)
    {
        this.cb = cb;
        criteriaQuery = cb.createQuery(klass);
        root = criteriaQuery.from(klass);
    }
    public CriteriaQueryBuilder<T> equals(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.equal(root.get(field), value));
        return this;
    }
    public CriteriaQueryBuilder<T> like(final String field, final String value)
    {
        if (value != null)
            predicates.add(cb.like(root.get(field), "%" + value + "%"));
        return this;
    }
    public <V extends Comparable<? super V>> CriteriaQueryBuilder<T> lessOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.lessThanOrEqualTo(root.get(field), value));
        return this;
    }
    public <V extends Comparable<? super V>> CriteriaQueryBuilder<T> greaterOrEqual(final String field, final V value)
    {
        if (value != null)
            predicates.add(cb.greaterThanOrEqualTo(root.get(field), value));
        return this;
    }
    public CriteriaQuery<T> build()
    {
        return criteriaQuery.where(cb.and(predicates.toArray(new Predicate[0])));
    }
}
