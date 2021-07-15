package ccard.models;

import ccard.strategy.NoCCMinPaymentStrategy;
import common.enums.AccountType;
import common.models.Account;
import common.models.Customer;
import common.strategy.InterestStrategy;

public abstract class CreditCard extends Account {

    private InterestStrategy minPaymentStrategy;

    public CreditCard(String id, Customer customer) {
        super(id, customer, AccountType.CREDIT);
        this.minPaymentStrategy = new NoCCMinPaymentStrategy();
    }

    public InterestStrategy getMinPaymentStrategy() {
        return minPaymentStrategy;
    }

    public void setMinPaymentStrategy(InterestStrategy minPaymentStrategy) {
        this.minPaymentStrategy = minPaymentStrategy;
    }
}
