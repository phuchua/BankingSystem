package ccard;

public class BronzeCard implements CreditCardStrategy {
    @Override
    public double getMonthlyInterest() {
        return 0.14;
    }

    @Override
    public double getMinimumPayment() {
        return 0.1;
    }
}
