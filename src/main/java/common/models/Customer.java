package common.models;

import common.enums.CustomerType;
import common.strategy.BalanceAlertStrategy;
import common.strategy.TransactionStrategy;
import framework.Storage.Storable;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public abstract  class Customer implements Storable<String> {

    private String id;
    private String name;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private CustomerType customerType;
    private BalanceAlertStrategy balanceAlertStrategy;
    private TransactionStrategy transactionStrategy;

    @Override
    public String getStorageKey() {
        return this.id;
    }

}
