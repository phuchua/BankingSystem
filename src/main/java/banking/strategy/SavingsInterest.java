package banking.strategy;

import common.strategy.InterestStrategy;

public class SavingsInterest implements InterestStrategy {
    public double calculateInterest(double balance) {
        if (balance < 1000){
            return 0.01*balance;
        } else if (balance < 5000) {
            return 0.02*balance;
        } else
            return 0.04*balance;
    }
}

