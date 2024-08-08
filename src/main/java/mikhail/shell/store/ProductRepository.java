package mikhail.shell.store;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Slf4j
public class ProductRepository<T extends Product> {
    protected final EntityManager entityManager;
    protected Class<T> klass;
    @Autowired
    public ProductRepository(final EntityManagerFactory entityManagerFactory)
    {
        entityManager = entityManagerFactory.createEntityManager();
    }
    public final CriteriaQueryBuilder<T> filter()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return new CriteriaQueryBuilder<>(cb, klass);
    }
    public final List<T> collect(final CriteriaQueryBuilder<T> builder)
    {
        final CriteriaQuery<T> criteriaQuery = builder.build();
        return entityManager.createQuery(criteriaQuery).getResultList();
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
