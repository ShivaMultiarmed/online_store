package mikhail.shell.store;

import mikhail.shell.store.models.ProductType;
import mikhail.shell.store.repositories.ProductTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductTypeRepositoryTester {
    @Autowired
    private ProductTypeRepository repository;
    @Test
    void testUpdatingProductType()
    {
        ProductType type = repository.getById(1L);
        type.setManufacturer("NiHao");
        type = repository.save(type);
    }
}
