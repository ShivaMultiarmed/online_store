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

    /*@Test
    void testTVRepositoryGettingAll() {
        final List<Fridge> all = fridgesRepository.findAll();
        assertNotNull(all);
    }

    @Test
    void testCreate() {
        Fridge fridge = new Fridge();
        fridge.setName("Atlant 0909090");
        fridge.setProduct_type(2L);
        fridge = fridgesRepository.save(fridge);
        assertNotNull(fridge.getId());
    }

    @Test
    void testUpdating() {
        Fridge fridge = fridgesRepository.findById(23L).orElse(null);
        fridge.setPrice(38000.0);
        fridge = fridgesRepository.save(fridge);
        assertNotEquals(50000.0, fridge.getPrice());
    }

    @Test
    void testDeleting() {
        final long[] idsToBeRemoved = {4, 5, 6};
        Arrays.stream(idsToBeRemoved).forEach(id -> {
            tvRepository.deleteById(id);
            assertFalse(tvRepository.existsById(id));
        });
    }

    @Test
    void testGettingAllProductTypes()
    {
        final List<ProductType> types = productTypeRepository.findAll();
        assertNotNull(types);
    }*/
    @Test
    void testFilter()
    {
        final CriteriaQueryBuilder<Fridge> fridgeCriteriaQueryBuilder = fridgesRepository.filter()
                .like("name", "Atlant")
                .lessOrEqual("price", 50_000.0);
        final List<Fridge> fridges = fridgesRepository.collect(fridgeCriteriaQueryBuilder);
        assertNotNull(fridges);
    }

}
