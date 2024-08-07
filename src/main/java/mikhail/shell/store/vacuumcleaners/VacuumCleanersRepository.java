package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.DBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class VacuumCleanersRepository extends DBRepository<VacuumCleaner> {
    @Autowired
    public VacuumCleanersRepository(final EntityManagerFactory entityManagerFactory)
    {
        super(entityManagerFactory);
        klass = VacuumCleaner.class;
    }
}