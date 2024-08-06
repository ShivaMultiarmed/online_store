package mikhail.shell.store.fridges;

import lombok.Data;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity @Table(name = "fridges", schema = "store_db")
public class Fridge extends Product {
    private Integer doors;
    private String compressor;
}
