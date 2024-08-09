package mikhail.shell.store.smartphones;

import mikhail.shell.store.db.StoreQueryBuilder;
import mikhail.shell.store.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SmartphoneService extends ProductService<SmartPhone> {
    @Autowired
    public SmartphoneService(final SmartphoneRepository repository) {
        super(repository, "smartphones");
    }

    @Override
    protected StoreQueryBuilder<SmartPhone> createSpecificProductFilter(final Map<String, String> params, StoreQueryBuilder<SmartPhone> filter) {
        if (params.containsKey("memory"))
            filter.equal("memory", Double.parseDouble(params.get("memory")));
        if (params.containsKey("cameras"))
            filter.equal("cameras", Integer.parseInt(params.get("cameras")));
        return filter;
    }
}
