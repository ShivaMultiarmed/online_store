package mikhail.shell.store;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;
import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Data @SuperBuilder @NoArgsConstructor
@Entity @Table(name = "products", schema = "store_db")
@Inheritance(strategy = TABLE_PER_CLASS)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_id_seq")
    @SequenceGenerator(name = "device_id_seq", sequenceName = "device_id_seq", allocationSize = 1)
    private Long id;
    private String name, color;
    private Boolean isPresent;
    private Long series;
    private Double price, width, height, length;
    private Long product_type;
}
