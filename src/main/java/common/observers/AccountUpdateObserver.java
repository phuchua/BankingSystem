package common.observers;

import common.models.*;
import framework.Observer.Observer;

public class AccountUpdateObserver implements Observer<Account> {
    @Override
    public void update(Account o) {
        if(o.getCustomer().getBalanceAlertStrategy() !=null){
            o.getCustomer().getBalanceAlertStrategy().checkForAlert(o);
        }
    }
}
