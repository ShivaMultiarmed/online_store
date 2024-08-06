package mikhail.shell.store.computers;

import lombok.Data;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity @Table(name = "computers", schema = "store_db")
public class Computer extends Product {
    private String category, processor;
}
