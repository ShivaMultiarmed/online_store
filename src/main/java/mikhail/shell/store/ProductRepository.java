package mikhail.shell.store;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ProductRepository<T extends Product>{
    protected final EntityManager entityManager;
    protected Class<T> klass;
    @Autowired
    public ProductRepository(final EntityManagerFactory entityManagerFactory)
    {
        entityManager = entityManagerFactory.createEntityManager();
    }
    public CriteriaQueryBuilder<T> filter()
    {
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        return new CriteriaQueryBuilder<>(cb, klass);
    }
    public List<T> collect(@NotNull final CriteriaQueryBuilder<T> builder)
    {
        final CriteriaQuery<T> criteriaQuery = builder.build();
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
    public T getById(final Long id)
    {
        return entityManager.find(klass, id);
    }
    public T create(T product)
    {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }
    public T update(T product)
    {
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        return product;
    }
    public void removeById(final Long id)
    {
        entityManager.getTransaction().begin();
        final T product = getById(id);
        if (product == null)
            return;
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }
}
