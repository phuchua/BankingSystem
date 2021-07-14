package framework.oldfiles.decorator;

import framework.oldfiles.strategy.InterestStrategy;

public class P2 extends InterestPromotionDecorator {
    private final double RATE = 0.02;

    public P2(InterestStrategy accType) {
        super(accType);
    }

    @Override
    public double calculateInterest(double balance) {
        return interestStrategy.calculateInterest(balance) * (1 + RATE);
    }
}
