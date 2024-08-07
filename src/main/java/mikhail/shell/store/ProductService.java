package mikhail.shell.store;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductService<T extends Product> {
    @Autowired
    protected final ProductRepository<T> repository;
    public List<T> filter(final Map<String, String> params)
    {
        final CriteriaQueryBuilder<T> filter = repository.filter();
        if (params.containsKey("maxPrice"))
            filter.lessOrEqual("price", Double.parseDouble(params.get("maxPrice")));
        return repository.collect(filter);
    }
    public T getById(final Long id)
    {
       return repository.getById(id);
    }
}
