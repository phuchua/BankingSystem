package framework.Storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DBStorage<O extends Storable<K>,K > implements Storage<O,K> {
    Map<K,O> data = new HashMap<K,O>();
    @Override
    public void create(O obj) {
        data.put(obj.getStorageKey(),obj);
    }

    @Override
    public void update(O obj) {
        data.put(obj.getStorageKey(),obj);
    }

    @Override
    public O loadByKey(K key) {
        if(data.containsKey(key))
            return data.get(key);
        else{
            return null;
        }
    }

    @Override
    public Collection<O> getAll() {
        return data.values();
    }
}
