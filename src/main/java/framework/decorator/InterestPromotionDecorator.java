package framework.decorator;

import framework.strategy.InterestStrategy;

public abstract class InterestPromotionDecorator implements InterestStrategy {
    InterestStrategy interestStrategy;

    protected  InterestPromotionDecorator(InterestStrategy accountType) {
        this.interestStrategy = accountType;
    }
}
