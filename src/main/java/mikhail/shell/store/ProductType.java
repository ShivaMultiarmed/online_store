package mikhail.shell.store;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;

@Data @NoArgsConstructor
@Entity @Table(name = "product_types", schema = "store_db")
public class ProductType {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name, country, manufacturer;
    private Boolean isOnline, hasInstallment;
//    @OneToMany(cascade = PERSIST, mappedBy = "productType")
//    private List<Product> products;
}
