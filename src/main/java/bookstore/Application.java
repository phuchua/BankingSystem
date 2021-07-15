package bookstore;

import bookstore.models.*;
import bookstore.services.CustomerService;
import bookstore.services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Application {

    public static CustomerService customerService = new CustomerService();
    public static OrderService orderService = new OrderService();

    public static void main(String[] args){

        Product p1 = new Book(UUID.randomUUID().toString(),"Design Paterns",100);
        Product p2 = new VideoTape(UUID.randomUUID().toString(),"Star wors",50);
        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);

        Customer c1 = customerService.createCustomer("Customer 1");
        Customer c2 = customerService.createCustomer("Customer 2");

        Order o1 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o1);
        Order o2 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o2);
        Order o3 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o3);
        Order o4 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o4);
        Order o5 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o5);
        Order o6 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o6);
        Order o7 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o7);
        Order o8 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o8);
        Order o9 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o9);
        Order o10 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o10);
        Order o11 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o11);
        Order o12 = orderService.createOrder(c1,products,new Paypal());
        c1.addOrder(o12);

        for(Order o:c1.getOrders()){
            System.out.println("Order# "+o.getId()+"      total: "+o.getTotal());
        }

    }
}
