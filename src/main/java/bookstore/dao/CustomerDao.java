package bookstore.dao;

import bookstore.models.Customer;
import common.models.Account;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;

public class CustomerDao extends DAO<Customer, String> {
    @Override
    public Storage<Customer, String> createStorageFactory() {
        return new MemoryStorage<Customer,String>();
    }
}
