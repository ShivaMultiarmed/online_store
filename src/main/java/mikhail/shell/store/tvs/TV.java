package mikhail.shell.store.tvs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.Product;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data @NoArgsConstructor @SuperBuilder
@Entity(name = "TV")
@Table(name = "tvs", schema = "store_db")
public class TV extends Product {
    private String color, category, technology;
}
