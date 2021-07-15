package ccard.strategy;

import common.strategy.InterestStrategy;

public class BronzeCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((14/100.0)*balance);
    }
}
