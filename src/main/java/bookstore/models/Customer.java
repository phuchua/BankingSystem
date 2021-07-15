package bookstore.models;

import framework.Storage.Storable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Customer implements Storable<String> {
    private String id;
    private String name;
    private List<Order> orders;

    public Customer(String id,String name){
        this.id = id;
        this.name = name;
        orders = new ArrayList<Order>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }
}
