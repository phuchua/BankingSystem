package bookstore.models;

import framework.Storage.Storable;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public abstract class Product implements Storable<String> {
    String id;
    String name;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    double price ;



    @Override
    public String getStorageKey() {
        return this.id;
    }
}
