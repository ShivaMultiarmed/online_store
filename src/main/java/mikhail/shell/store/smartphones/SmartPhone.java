package mikhail.shell.store.smartphones;

import lombok.Data;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity @Table(name = "smartphones", schema="store_db")
public class SmartPhone extends Product {
    private double memory;
    private int cameras;
}
