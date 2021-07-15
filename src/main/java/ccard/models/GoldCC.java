package ccard.models;

import ccard.strategy.GoldCCInterestStrategy;
import common.enums.AccountType;
import common.models.Customer;

public class GoldCC extends CreditCard {
    public GoldCC(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new GoldCCInterestStrategy());
    }
}
