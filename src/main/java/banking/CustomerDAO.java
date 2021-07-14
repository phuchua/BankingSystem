package banking;

import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;
import framework.Storage.StorageFactory;

public class CustomerDAO extends DAO<Customer,String> {
    @Override
    public Storage<Customer, String> createStorageFactory() {
        return new MemoryStorage<Customer,String>();
    }
}
