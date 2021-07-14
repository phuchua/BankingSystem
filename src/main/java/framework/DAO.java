package framework;

import framework.Storage.Storable;
import framework.Storage.Storage;

import java.util.Collection;

public abstract class DAO<O extends Storable<K>,K> {
    private Storage<O,K> storage;

    public DAO(){
        this.storage = createStorageFactory();
    }

    public abstract Storage<O,K> createStorageFactory();

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
