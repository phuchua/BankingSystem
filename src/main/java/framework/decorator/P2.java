package framework.decorator;

import framework.strategy.InterestStrategy;

public class P2 extends InterestPromotionDecorator {
    private final double RATE = 0.02;

    public P2(InterestStrategy accType) {
        super(accType);
    }

    @Override
    public double computeInterest(double balance) {
        return interestStrategy.computeInterest(balance) * (1 + RATE);
    }
}
