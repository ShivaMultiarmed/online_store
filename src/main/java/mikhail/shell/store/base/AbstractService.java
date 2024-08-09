package mikhail.shell.store.base;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<T, K extends AbstractRepository<T>>  {
    protected final K repository;
    public final T getById(final Long id)
    {
        return repository.getById(id);
    }
    public final T create(final T product)
    {
        return repository.create(product);
    }
    public final T update(final T product)
    {
        return repository.update(product);
    }
    public final void removeById(final Long id)
    {
        repository.removeById(id);
    }
}
