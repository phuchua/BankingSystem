package common.observers;

import common.models.Account;
import common.models.Customer;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;
import framework.Observer.Observer;

public class AccountCreateObserver implements Observer<Customer> {

    @Override
    public void update(Account o) {
        EmailMessage message = new EmailMessage(o.getCustomer().getEmail(),"Account #"+o.getId()+" Created"," Created for: "+o.getCustomer().getName());
        (new EmailNotification(message)).send();
    }
}
