package mikhail.shell.store;

import mikhail.shell.store.fridges.Fridge;
import mikhail.shell.store.fridges.FridgesRepository;
import mikhail.shell.store.tvs.TV;
import mikhail.shell.store.tvs.TVRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryTester {
    @Autowired
    private TVRepository tvRepository;
    @Autowired
    private FridgesRepository fridgesRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Test
    void testTVRepositoryGettingAllTVs()
    {
        final List<ProductType> all = productTypeRepository.findAll();
        assertNotNull(all);
    }
    @Test
    void testCreate()
    {
         TV tv = new TV();
        tv.setName("Xiaomi 5000");
        tv.setPrice(599.0);
        tv = tvRepository.save(tv);

        /*Fridge fridge = new Fridge();
        fridge.setName("LG 100500");
        fridge.setProduct_type(2L);
        fridge = fridgesRepository.save(fridge);*/
        assertNotNull(tv.getId());
    }
    @Test
    void testUpdatingTV()
    {
        TV tv = new TV();
        tv.setId(6L);
        tv.setName("Xiaomi 5000");
        tv.setPrice(599.0);

        tv.setPrice(299.0);
        tv = tvRepository.save(tv);
        assertNotEquals(599, tv.getPrice());
    }
    @Test
    void testDeletingTv()
    {
        final long[] idsToBeRemoved = {4, 5, 6};
        Arrays.stream(idsToBeRemoved).forEach(id -> {
            tvRepository.deleteById(id);
            assertFalse(tvRepository.existsById(id));
        });
    }

}
