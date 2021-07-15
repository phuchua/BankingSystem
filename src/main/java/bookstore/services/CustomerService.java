package bookstore.services;

import bookstore.models.Customer;
import bookstore.models.Order;
import bookstore.models.PaymentMethod;
import bookstore.models.Product;
import bookstore.repositories.CustomerRepository;
import bookstore.repositories.OrderRepository;

import java.util.List;
import java.util.UUID;

public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(){
        customerRepository = new CustomerRepository();
    }

    public Customer createCustomer(String name){
        Customer customer= new Customer(UUID.randomUUID().toString(),name);
        customerRepository.save(customer);
        return customer;
    }
    public void updateCustomer(Customer customer){
        customerRepository.update(customer);
    }

}
