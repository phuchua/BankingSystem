package bookstore.repositories;

import bookstore.dao.CustomerDao;
import bookstore.models.Customer;
import framework.DAO;
import framework.EntityRepository;

public class CustomerRepository extends EntityRepository<Customer,String> {
    @Override
    public DAO<Customer, String> getDao() {
        return new CustomerDao();
    }
}
