package common.models;


import common.enums.AccountType;
import common.strategy.InterestStrategy;
import framework.Storage.Storable;
import lombok.Data;

import java.util.List;

@Data
public  class Account implements Storable<String> {
    private String id;
    private InterestStrategy interestStrategy;
    private Customer customer;
    private AccountType accountType;
    private Double balance = 0.0;
    private List<AccountEntry> entryList;

    public Account(String id, Customer customer, AccountType accountType) {
        this.id = id;
        this.customer = customer;
        this.accountType = accountType;
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }

    public void deposit(double amount, String description) {
        AccountEntry entry = new AccountEntry(amount, description, "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount, String description) {
        AccountEntry entry = new AccountEntry(-amount, description, "", "");
        entryList.add(entry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }
}
