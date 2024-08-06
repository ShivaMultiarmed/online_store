package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacuumCleanersRepository extends ProductRepository<VacuumCleaner> {
}
