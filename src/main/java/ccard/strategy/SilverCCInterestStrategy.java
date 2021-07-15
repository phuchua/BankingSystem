package ccard.strategy;

import common.strategy.InterestStrategy;

public class SilverCCInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return -((8/100)*balance);
    }
}
