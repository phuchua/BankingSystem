package framework.oldfiles.strategy;

public class CheckingsInterest implements InterestStrategy {
    public double calculateInterest(double balance) {
        if (balance < 1000){
            return 0.015*balance;
        } else
            return 0.025*balance;
    }
}
