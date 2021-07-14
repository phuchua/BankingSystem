package framework.core;

import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    protected static List<Customer> customers = new ArrayList<>();

    static {
        Customer customer1= new Customer( "John", "john@gmail.com", "1000 North St", "Fairfield", "Iowa", "52556");
        Customer customer2 = new Customer("David", "david@gmail.com", "2000 Utopia", "Fairfield", "Iowa", "52556");

        customers.add(customer1);
        customers.add(customer2);
    }
}
