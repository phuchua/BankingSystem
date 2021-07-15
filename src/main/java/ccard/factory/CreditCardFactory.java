package ccard.factory;

import ccard.enums.CreditCardType;
import ccard.models.BronzeCC;
import ccard.models.CreditCard;
import ccard.models.GoldCC;
import ccard.models.SilverCC;
import common.models.Customer;

public class CreditCardFactory {
    public static CreditCard createCredCard(CreditCardType cardType, String id, Customer customer) {
        CreditCard creditCard = null;

        if (cardType == CreditCardType.BRONZE) {
            creditCard = new BronzeCC(id, customer);
        } else if (cardType == CreditCardType.GOLD) {
            creditCard = new GoldCC(id, customer);
        } else if (cardType == CreditCardType.SILVER) {
            creditCard = new SilverCC(id, customer);
        }

        creditCard.setMinPaymentStrategy(MinPaymentStrategyFactory.getMinPaymentStrategy(cardType));
        return creditCard;

    }
}
