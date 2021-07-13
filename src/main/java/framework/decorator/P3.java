package framework.decorator;

import framework.strategy.InterestStrategy;

public class P3 extends InterestPromotionDecorator {
    private final double RATE = 0.03;

    public P3(InterestStrategy accType) {
        super(accType);
    }

    @Override
    public double computeInterest(double balance) {
        return interestStrategy.computeInterest(balance) * (1 + RATE);
    }
}
