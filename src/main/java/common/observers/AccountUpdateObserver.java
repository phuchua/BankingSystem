package common.observers;

import common.models.*;
import framework.Components.Notification.Email.EmailMessage;
import framework.Components.Notification.Email.EmailNotification;
import framework.Observer.Observer;

public class AccountUpdateObserver implements Observer<Customer> {

    @Override
    public void update(Account o) {
        this.check(o.getCustomer(),o);
    }

    private void check(Company customer, Account account){

    }

    private void check(Person customer, Account account){
        if(account.getBalance() < 0){
            EmailMessage message = new EmailMessage(customer.getEmail(),"Account Balance Issue","Account Balance below 0 on account#: "+o.getAccount().getId());
            (new EmailNotification(message)).send();
        }

    }


}
