package mikhail.shell.store.fridges;

import mikhail.shell.store.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FridgesRepository extends ProductRepository<Fridge> {
}
