package framework.core;

import java.util.Collection;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public void saveCustomer(Customer customer) {
        CustomerDB.customers.add(customer);
    }

    @Override
    public Collection<Customer> getCustomerList() {
        return CustomerDB.customers;
    }
}