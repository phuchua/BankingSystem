package banking.strategy;

import common.models.AccountEntry;
import common.strategy.TransactionStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class CompanyTransactionStrategy implements TransactionStrategy {
    @Override
    public void checkForAlert(AccountEntry accountEntry) {
        EmailMessage message = new EmailMessage(accountEntry.getAccount().getCustomer().getEmail(),"Company Account Transaction","Company Account >> Deposit on account#: " + accountEntry.getAccount().getId() + ", amount: " + accountEntry.getAmount());
        (new EmailNotification(message)).send();
    }
}
