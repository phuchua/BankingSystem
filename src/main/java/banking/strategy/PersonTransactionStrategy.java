package banking.strategy;

import common.models.AccountEntry;
import common.strategy.TransactionStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class PersonTransactionStrategy implements TransactionStrategy {
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        if(Math.abs(accountEntry.getAmount()) > 500 || accountEntry.getAmount() < 0){
            EmailMessage message = new EmailMessage(accountEntry.getAccount().getCustomer().getEmail(),"Account Transaction","Personal Account >> Deposit on account#: " + accountEntry.getAccount().getId() + ", amount: " + accountEntry.getAmount());
            (new EmailNotification(message)).send();
        }
    }
}