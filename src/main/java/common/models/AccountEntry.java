package common.models;

import framework.Storage.Storable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public  class AccountEntry implements Storable<String> {

    private String id;
    private Date date;
    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;


    public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }

}
