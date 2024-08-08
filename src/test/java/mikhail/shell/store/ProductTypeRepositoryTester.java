package mikhail.shell.store;

import org.junit.jupiter.api.Assertions;
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
    void testGet()
    {
        final long id = 2L;
        final ProductType expected = ProductType.builder()
                .id(id)
                .name("fridges")
                .country("Belarus")
                .manufacturer("Atlant")
                .isOnline(false)
                .hasInstallment(true)
                .build();
        final ProductType actual = repository.getType(2L);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
