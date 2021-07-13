package framework.decorator;

import framework.strategy.InterestStrategy;

public class P1 extends InterestPromotionDecorator {
    private final double RATE = 0.01;

    public P1(InterestStrategy accType) {
        super(accType);
    }

    @Override
    public double computeInterest(double balance) {
        return interestStrategy.computeInterest(balance) * (1 + RATE);
    }
}
