package mikhail.shell.store.fridges;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "fridges", schema = "store_db")
public class Fridge extends Product {
    private Integer doors;
    private String compressor;

}
