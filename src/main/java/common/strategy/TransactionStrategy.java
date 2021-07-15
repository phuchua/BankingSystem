package common.strategy;

import common.models.AccountEntry;

public interface TransactionStrategy {
    void checkForAlert(AccountEntry accountEntry);
}
