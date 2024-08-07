package mikhail.shell.store.fridges;

import lombok.RequiredArgsConstructor;
import mikhail.shell.store.CriteriaQueryBuilder;
import mikhail.shell.store.DBRepository;
import mikhail.shell.store.Product;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class FridgesRepository extends DBRepository<Fridge> {
    @Autowired
    public FridgesRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = Fridge.class;
    }
}
