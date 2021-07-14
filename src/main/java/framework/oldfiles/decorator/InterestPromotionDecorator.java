package framework.oldfiles.decorator;

import framework.oldfiles.strategy.InterestStrategy;

public abstract class InterestPromotionDecorator implements InterestStrategy {
    InterestStrategy interestStrategy;

    protected  InterestPromotionDecorator(InterestStrategy accountType) {
        this.interestStrategy = accountType;
    }
}
