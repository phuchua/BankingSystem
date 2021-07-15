package bookstore.repositories;

import bookstore.dao.OrderDao;
import bookstore.models.Customer;
import bookstore.models.Order;
import framework.DAO;
import framework.EntityRepository;

public class OrderRepository extends EntityRepository<Order,String> {
    @Override
    public DAO<Order, String> getDao() {
        return new OrderDao();
    }
}
