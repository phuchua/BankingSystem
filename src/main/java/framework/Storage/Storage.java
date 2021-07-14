package framework.Storage;

import java.util.Collection;

public interface Storage<O extends Storable<K>,K> {
    void create(O obj);
    void update(O obj);
    O loadByKey(K key);
    Collection<O> getAll();
}
