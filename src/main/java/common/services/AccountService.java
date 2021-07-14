package common.services;


import common.models.Account;
import common.models.Customer;

public interface AccountService {
    public void createAccount(Account account, Customer customer);
}
