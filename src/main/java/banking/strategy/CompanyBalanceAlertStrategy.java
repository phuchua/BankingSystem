package banking.strategy;

import common.models.Account;
import common.strategy.BalanceAlertStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class CompanyBalanceAlertStrategy implements BalanceAlertStrategy {

    @Override
    public void checkForAlert(Account account) {
        if(account.getBalance() < 0){
            EmailMessage message = new EmailMessage(account.getCustomer().getEmail(),"Account Balance","Company Account >> Balance issued on account#: " + account.getId() + ", balance: " + account.getBalance());
            (new EmailNotification(message)).send();
        }
    }
}
