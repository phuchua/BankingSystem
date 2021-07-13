package framework;

import java.util.Collection;

public class DAO<O extends Storable<K>,K> {
    private Storage<O,K> storage;

    public DAO(Storage<O,K> storage){
        this.storage = storage;
    }

    public void create(O obj) {
        storage.create(obj);
    }

    public void update(O obj) {
        storage.update(obj);
    }

    public O loadOne(K key) {
        return storage.loadByKey(key);
    }

    public Collection<O> getAll() {
        return storage.getAll();
    }
}
