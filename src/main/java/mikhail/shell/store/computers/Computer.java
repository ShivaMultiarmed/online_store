package mikhail.shell.store.computers;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "computers", schema = "store_db")
public class Computer extends Product {
    private String category, processor;
}
