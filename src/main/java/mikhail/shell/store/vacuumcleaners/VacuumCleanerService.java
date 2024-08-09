package mikhail.shell.store.vacuumcleaners;

import mikhail.shell.store.db.StoreQueryBuilder;
import mikhail.shell.store.product.ProductService;
import mikhail.shell.store.smartphones.SmartPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VacuumCleanerService extends ProductService<VacuumCleaner> {
    @Autowired
    public VacuumCleanerService(final VacuumCleanerRepository repository) {
        super(repository, "vacuum_cleaners");
    }

    @Override
    protected StoreQueryBuilder<VacuumCleaner> createSpecificProductFilter(final Map<String, String> params, StoreQueryBuilder<VacuumCleaner> filter) {
        if (params.containsKey("minVolume"))
            filter.greaterOrEqual("volume", Double.parseDouble(params.get("mivVolume")));
        if (params.containsKey("maxVolume"))
            filter.lessOrEqual("volume", Double.parseDouble(params.get("maxVolume")));
        if (params.containsKey("modes"))
            filter.equal("modes", Integer.parseInt(params.get("modes")));
        return filter;
    }
}