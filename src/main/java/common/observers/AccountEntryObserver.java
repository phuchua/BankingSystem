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
    public void update(AccountEntry o)
    {
        if(o.getAccount().getCustomer().getTransactionStrategy() !=null){
            o.getAccount().getCustomer().getTransactionStrategy().checkForAlert(o);
        }

    }


}
