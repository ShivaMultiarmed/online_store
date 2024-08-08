package mikhail.shell.store;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ProductService<T extends Product> {
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
    public T create(final T product)
    {
        return repository.create(product);
    }
    public T update(final T product)
    {
        return repository.update(product);
    }
    public void removeById(final Long id)
    {
        repository.removeById(id);
    }
}