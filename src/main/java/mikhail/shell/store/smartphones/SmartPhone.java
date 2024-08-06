package mikhail.shell.store.smartphones;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "smartphones", schema="store_db")
public class SmartPhone extends Product {
    private double memory;
    private int cameras;
}
