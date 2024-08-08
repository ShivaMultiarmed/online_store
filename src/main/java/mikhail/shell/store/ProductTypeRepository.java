package mikhail.shell.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Query(value = "SELECT * FROM store_db.product_types types" +
            " INNER JOIN store_db.products products ON products.product_type = types.id" +
            " WHERE types.id = :id ", nativeQuery = true)
    ProductType getType(@Param("id") Long id);
}
