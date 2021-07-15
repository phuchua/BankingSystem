package ccard.models;

import ccard.strategy.GoldCCInterestStrategy;
import ccard.strategy.SilverCCInterestStrategy;
import common.enums.AccountType;
import common.models.Customer;

public class SilverCC extends CreditCard {
    public SilverCC(String id, Customer customer) {
        super(id, customer);
        this.setInterestStrategy(new SilverCCInterestStrategy());
    }
}
