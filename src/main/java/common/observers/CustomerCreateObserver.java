package common.observers;

import common.models.Customer;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;
import framework.Observer.Observer;

public class CustomerCreateObserver implements Observer<Customer> {

    @Override
    public void update(Customer o) {
        EmailMessage message = new EmailMessage(o.getEmail(),"Account Created","Account Created for: "+o.getName());
        (new EmailNotification(message)).send();
    }
}
