package mikhail.shell.store.smartphones;

import mikhail.shell.store.ProductRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository  extends ProductRepository<SmartPhone> {
}
