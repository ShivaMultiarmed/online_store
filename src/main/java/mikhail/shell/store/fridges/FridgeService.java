package mikhail.shell.store.fridges;

import mikhail.shell.store.db.StoreQueryBuilder;
import mikhail.shell.store.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FridgeService extends ProductService<Fridge> {
    @Autowired
    public FridgeService(final FridgeRepository repository) {
        super(repository, "fridges");
    }

    @Override
    protected StoreQueryBuilder<Fridge> createSpecificProductFilter(final Map<String, String> params, StoreQueryBuilder<Fridge> filter) {
        if (params.containsKey("doors"))
            filter.equal("doors", Integer.parseInt(params.get("category")));
        if (params.containsKey("compressor"))
            filter.equal("compressor", params.get("compressor"));
        return filter;
    }
}