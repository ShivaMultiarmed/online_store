package mikhail.shell.store.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class AbstractRepository<T> {
    protected final EntityManager entityManager;
    protected Class<T> klass;
    @Autowired
    public AbstractRepository(final EntityManagerFactory entityManagerFactory)
    {
        entityManager = entityManagerFactory.createEntityManager();
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
