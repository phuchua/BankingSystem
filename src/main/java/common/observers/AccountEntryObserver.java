package common.observers;

import common.models.AccountEntry;
import common.models.Company;
import common.models.Customer;
import common.models.Person;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;
import framework.Observer.Observer;

public class AccountEntryObserver implements Observer<AccountEntry> {

    @Override
    public void update(AccountEntry o) {
        this.check(o.getAccount().getCustomer(),o);
    }

    private void check(Company customer,AccountEntry accountEntry){
        EmailMessage message = new EmailMessage(customer.getEmail(),"Account Transaction","Account Transaction on account#: "+o.getAccount().getId());
        (new EmailNotification(message)).send();
    }

    private void check(Person customer, AccountEntry accountEntry){
        if(Math.abs(accountEntry.getAmount()) > 500  ){
            EmailMessage message = new EmailMessage(customer.getEmail(),"Account Transaction","Account Transaction on account#: "+o.getAccount().getId());
            (new EmailNotification(message)).send();
        }
    }
}
