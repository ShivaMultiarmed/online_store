package mikhail.shell.store;

import mikhail.shell.store.models.Product;
import mikhail.shell.store.repositories.ProductRepository;
import mikhail.shell.store.repositories.ProductTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTester {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Test
    @Transactional
    void testGettingProduct()
    {
        final Product expected = Product.builder().id(30L).name("laptop zenbook ultra").series(202402L).price(78900.0)
                .isPresent(true).width(32.5).height(22.7).length(1.9).color("silver")//.processor("Intel i7").category("ultrabook").product_type(13L)
                .build();
        final Product actual = productRepository.findById(30L).orElse(null);
        assertEquals(expected, actual);
    }
}
