package banking.strategy;

import common.models.Account;
import common.strategy.BalanceAlertStrategy;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;

public class PersonBalanceAlertStrategy implements BalanceAlertStrategy {

    @Override
    public void checkForAlert(Account account) {
        if(account.getBalance() < 0){
            EmailMessage message = new EmailMessage(account.getCustomer().getEmail(),"Account Balance Issue","Account Balance below 0 on account#: "+account.getId());
            (new EmailNotification(message)).send();
        }
    }
}
