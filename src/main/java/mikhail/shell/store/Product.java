package mikhail.shell.store;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;

@Data
@Entity @Table(name = "products", schema = "store_db")
@Inheritance(strategy = JOINED)
public class Product {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private Boolean isPresent;
    private Long series;
    private Double price, width, height, length;
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private ProductType product_type;
}
