package ccard.strategy;

import common.strategy.InterestStrategy;

public class NoCCMinPaymentStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return (0);
    }
}
