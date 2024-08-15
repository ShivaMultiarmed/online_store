package mikhail.shell.store.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import mikhail.shell.store.converters.MapToStringConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Map;

import static javax.persistence.GenerationType.SEQUENCE;


@Data @SuperBuilder @NoArgsConstructor
@Entity @Table(name = "products", schema = "store_db")
public class Product implements Serializable {
    @Id @GeneratedValue(strategy = SEQUENCE, generator = "device_id_seq")
    @SequenceGenerator(name = "device_id_seq", sequenceName = "device_id_seq", allocationSize = 1)
    private Long id;
    private String name, color;
    private Boolean isPresent;
    private Long series;
    private Double price, width, height, length;
    private Long product_type;
    @Column(columnDefinition = "hstore")
    @Convert(converter = MapToStringConverter.class)
    protected Map<String, Object> details;
}
