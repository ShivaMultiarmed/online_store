package mikhail.shell.store.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "product_types", schema = "store_db")
public class ProductType implements Serializable {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name, country, manufacturer;
    private Boolean isOnline, hasInstallment;
    //@OneToMany(fetch = EAGER)
    //@JoinColumn(name = "product_type")
    @Transient
    private List<Product> products = new ArrayList<>();
}
