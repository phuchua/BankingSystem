package common.models;


import common.enums.AccountType;
import common.strategy.InterestStrategy;
import framework.Storage.Storable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Account implements Storable<String> {
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
        entryList = new ArrayList<AccountEntry>();
    }

    public void addInterest(){
        double balance = getBalance();
        double amount = interestStrategy.calculateInterest(balance);
        AccountEntry entry = new AccountEntry(amount, "interest", "", "");
    }

    @Override
    public String getStorageKey() {
        return this.id;
    }

    public void addEntry(AccountEntry accountEntry){
        entryList.add(accountEntry);
    }

    public String getAccountNumber() {
        return id;
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName());

        entryList.add(fromEntry);
        toAccount.addEntry(toEntry);
    }
}
