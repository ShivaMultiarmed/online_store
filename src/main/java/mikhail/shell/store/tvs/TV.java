package mikhail.shell.store.tvs;

import lombok.Data;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity(name = "TV")
@Table(name = "tvs", schema = "store_db")
public class TV extends Product {
    private String color, category, technology;
}
