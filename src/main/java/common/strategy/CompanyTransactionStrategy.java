package common.strategy;

import common.models.AccountEntry;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class CompanyTransactionStrategy implements TransactionStrategy{
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        EmailMessage message = new EmailMessage(accountEntry.getAccount().getCustomer().getEmail(),"Account Transaction","Account Transaction on account#: "+accountEntry.getAccount().getId());
        (new EmailNotification(message)).send();
    }
}
