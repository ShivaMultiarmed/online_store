package mikhail.shell.store.tvs;

import mikhail.shell.store.db.StoreQueryBuilder;
import mikhail.shell.store.product.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TVService extends ProductService<TV> {
    @Autowired
    public TVService(final TVRepository repository) {
        super(repository, "tvs");
    }

    @Override
    protected StoreQueryBuilder<TV> createSpecificProductFilter(final Map<String, String> params, StoreQueryBuilder<TV> filter) {
        if (params.containsKey("category"))
            filter.equal("category", params.get("category"));
        if (params.containsKey("technology"))
            filter.equal("technology", params.get("technology"));
        return filter;
    }
}