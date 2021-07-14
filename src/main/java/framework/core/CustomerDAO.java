package framework.core;

import java.util.Collection;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    Collection<Customer> getCustomerList();
}
