package mikhail.shell.store.computers;

import mikhail.shell.store.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputersRepository extends ProductRepository<Computer> {
}
