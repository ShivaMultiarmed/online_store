package mikhail.shell.store.vacuumcleaners;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @SuperBuilder
@Entity @Table(name = "vacuum_cleaners", schema = "store_db")
public class VacuumCleaner extends Product {
    private String color;
    private double volume;
    private int modes;
}
