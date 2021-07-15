package common.strategy;

import common.models.Account;
import common.models.Customer;

public interface BalanceAlertStrategy {
    void checkForAlert(Account account);
}
