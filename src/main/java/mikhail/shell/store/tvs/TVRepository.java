package mikhail.shell.store.tvs;

import mikhail.shell.store.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVRepository extends ProductRepository<TV> {
}
