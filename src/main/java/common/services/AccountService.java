package common.services;


import common.models.Account;
import common.models.Customer;
import framework.Service;

import java.util.Collection;

public interface AccountService extends Service {
    Account createAccount(Account account, Customer customer);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    Collection<Account> getAllAccounts();
    Account getAccountById(String accountId);
    void setInterest();
}
