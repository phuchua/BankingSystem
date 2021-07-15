package bookstore.dao;

import bookstore.models.Order;
import framework.DAO;
import framework.Storage.MemoryStorage;
import framework.Storage.Storage;

public class OrderDao extends DAO<Order, String> {
    @Override
    public Storage<Order, String> createStorageFactory() {
        return new MemoryStorage<Order,String>();
    }
}
