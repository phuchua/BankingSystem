package common.dao;

import common.models.Customer;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;

public class CustomerDAO extends DAO<Customer,String> {
    @Override
    public Storage<Customer, String> createStorageFactory() {
        return new MemoryStorage<Customer,String>();
    }
}
