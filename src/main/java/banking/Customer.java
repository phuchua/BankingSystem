package banking;

import framework.Storage.Storable;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public  class Customer implements Storable<String> {
    private String id;
    private String name;
    private String email;

    @Override
    public String getStorageKey() {
        return this.id;
    }
}
