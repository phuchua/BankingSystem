package banking.strategy;

import common.strategy.InterestStrategy;

public class BasicAccountInterestStrategy implements InterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return (1/100.0) * balance;
    }
}
