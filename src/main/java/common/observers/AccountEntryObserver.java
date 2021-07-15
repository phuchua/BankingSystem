package common.observers;

import common.models.AccountEntry;
import framework.observer.Observer;

public class AccountEntryObserver implements Observer<AccountEntry> {

    @Override
    public void update(AccountEntry o)
    {
        if(o.getAccount().getCustomer().getTransactionStrategy() !=null){
            o.getAccount().getCustomer().getTransactionStrategy().checkForAlert(o);
        }
    }


}
