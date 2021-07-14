package framework.core;

import java.util.ArrayList;
import java.util.Collection;

public class MockAccountDAO implements AccountDAO {
    Collection<Account> accountlist = new ArrayList<Account>();
    private final String MOCK = "MOCK_";

    public void saveAccount(Account account) {
        account.setAccountNumber(MOCK + account.getAccountNumber());
        accountlist.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountexist = loadAccount(MOCK + account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }

    }

    public Account loadAccount(String accountNumber) {
        accountNumber = MOCK + accountNumber;
        for (Account account : accountlist) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
