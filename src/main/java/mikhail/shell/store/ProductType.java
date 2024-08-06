package mikhail.shell.store;

import lombok.Data;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity @Table(name = "product_types", schema = "store_db")
public class ProductType {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name, country, manufacturer;
    private Boolean isOnline, hasInstallment;
    @OneToMany(cascade = ALL, mappedBy = "product_type")
    private List<Product> products;
}
