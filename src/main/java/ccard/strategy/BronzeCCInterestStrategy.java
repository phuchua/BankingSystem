package ccard.strategy;

import common.strategy.InterestStrategy;

public class BronzeCCInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return ((10/100.0)*balance);
    }
}
