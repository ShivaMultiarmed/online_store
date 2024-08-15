package mikhail.shell.store.services;

import javax.transaction.Transactional;
import java.io.Serializable;

public interface AbstractService<T extends Serializable>  {
    T getById(final Long id);
    T create(final T product);
    T update(final T product);
    void removeById(final Long id);
}
