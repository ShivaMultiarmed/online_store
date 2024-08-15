package mikhail.shell.store.repositories;

import mikhail.shell.store.models.ProductType;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {

}
