package common.services;


import common.models.Account;
import common.models.Customer;

public interface AccountService {
    void createAccount(Account account, Customer customer);

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
}
