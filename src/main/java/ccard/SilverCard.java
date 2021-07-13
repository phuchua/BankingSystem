package ccard;

public class SilverCard implements CreditCardStrategy {
    @Override
    public double getMonthlyInterest() {
        return 0.12;
    }

    @Override
    public double getMinimumPayment() {
        return 0.08;
    }
}
