package framework.strategy;

public class SavingsInterest implements InterestStrategy {
    public double computeInterest(double balance) {
        if (balance < 1000){
            return 0.01*balance;
        } else if (balance < 5000) {
            return 0.02*balance;
        } else
            return 0.04*balance;
    }
}
