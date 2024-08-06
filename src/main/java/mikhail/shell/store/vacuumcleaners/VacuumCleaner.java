package mikhail.shell.store.vacuumcleaners;

import lombok.Data;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity @Table(name = "vacuum_cleaners", schema = "store_db")
public class VacuumCleaner extends Product {
    private String color;
    private double volume;
    private int modes;
}
