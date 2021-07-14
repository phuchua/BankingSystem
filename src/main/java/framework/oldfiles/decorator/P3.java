package framework.oldfiles.decorator;

import framework.oldfiles.strategy.InterestStrategy;

public class P3 extends InterestPromotionDecorator {
    private final double RATE = 0.03;

    public P3(InterestStrategy accType) {
        super(accType);
    }

    @Override
    public double calculateInterest(double balance) {
        return interestStrategy.calculateInterest(balance) * (1 + RATE);
    }
}

