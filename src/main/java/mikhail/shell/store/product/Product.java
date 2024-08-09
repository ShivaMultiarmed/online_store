package mikhail.shell.store.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Data @SuperBuilder @NoArgsConstructor
@Entity @Table(name = "products", schema = "store_db")
@Inheritance(strategy = TABLE_PER_CLASS)
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_id_seq")
    @SequenceGenerator(name = "device_id_seq", sequenceName = "device_id_seq", allocationSize = 1)
    protected Long id;
    protected String name, color;
    protected Boolean isPresent;
    protected Long series;
    protected Double price, width, height, length;
    protected Long product_type;
}
