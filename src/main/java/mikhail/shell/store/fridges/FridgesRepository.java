package mikhail.shell.store.fridges;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.CriteriaQueryBuilder;
import mikhail.shell.store.Product;
import mikhail.shell.store.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FridgesRepository {
    @PersistenceContext
    private final EntityManager entityManager;
    public CriteriaQueryBuilder<Fridge> filter()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return new CriteriaQueryBuilder<>(cb, Fridge.class);
    }
    public List<Fridge> collect(final CriteriaQueryBuilder<Fridge> builder)
    {   final CriteriaQuery<Fridge> criteriaQuery = builder.build();
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
