package ccard.models;

import common.enums.AccountType;
import common.models.Account;
import common.models.Customer;

public abstract class CreditCard extends Account {
    public CreditCard(String id, Customer customer) {
        super(id, customer, AccountType.CREDIT);
    }
}
