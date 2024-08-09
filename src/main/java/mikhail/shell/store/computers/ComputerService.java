package mikhail.shell.store.computers;

import mikhail.shell.store.db.StoreQueryBuilder;
import mikhail.shell.store.product.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ComputerService extends ProductService<Computer> {
    @Autowired
    public ComputerService(final ComputerRepository repository) {
        super(repository, "computers");
    }

    @Override
    protected StoreQueryBuilder<Computer> createSpecificProductFilter(final Map<String, String> params, StoreQueryBuilder<Computer> filter) {
        if (params.containsKey("category"))
            filter.equal("category", params.get("category"));
        if (params.containsKey("processor"))
            filter.equal("processor", params.get("processor"));
        return filter;
    }
}