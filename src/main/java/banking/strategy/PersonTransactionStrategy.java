package banking.strategy;

import common.models.AccountEntry;
import common.strategy.TransactionStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class PersonTransactionStrategy implements TransactionStrategy {
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        if(Math.abs(accountEntry.getAmount()) > 500  ){
            EmailMessage message = new EmailMessage(accountEntry.getAccount().getCustomer().getEmail(),"Account Transaction","BIG Account Transaction on account#: "+accountEntry.getAccount().getId());
            (new EmailNotification(message)).send();
        }
    }
}
