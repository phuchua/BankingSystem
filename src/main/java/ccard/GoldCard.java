package ccard;

public class GoldCard implements CreditCardStrategy {
    @Override
    public double getMonthlyInterest() {
        return 0.1;
    }

    @Override
    public double getMinimumPayment() {
        return 0.06;
    }
}
