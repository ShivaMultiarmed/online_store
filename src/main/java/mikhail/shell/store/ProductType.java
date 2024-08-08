package mikhail.shell.store;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "product_types", schema = "store_db")
public class ProductType {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name, country, manufacturer;
    private Boolean isOnline, hasInstallment;
    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "product_type")
    private List<Product> products;
}
