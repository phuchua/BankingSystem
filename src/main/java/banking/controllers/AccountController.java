package banking.controllers;

import common.enums.AccountType;
import common.models.*;
import common.services.AccountService;
import banking.services.AccountServiceImpl;
import framework.Controller;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

public class AccountController implements Controller {
    AccountService accountService;

    public AccountController(){
        accountService = new AccountServiceImpl();
    }

    public Account createPersonalAccount(String name, String street, String city, String state, String zip, String email, Date dob, AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer person = new Person(uuid.toString(),name,street,city,state,zip,email,dob);
        uuid = UUID.randomUUID();
       Account account = new Account(uuid.toString(),person,accountType);
       return accountService.createAccount(account,person);
    }

    public Account createCompanyAccount(String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer company = new Company(uuid.toString(),name,street,city,state,zip,email,numberOfEmployees);
        uuid = UUID.randomUUID();
        Account account = new Account(uuid.toString(),company,accountType);
        return accountService.createAccount(account,company);
    }

    public void deposit(String accountNumber, double amount) {
        accountService.deposit(accountNumber,amount);
    }


    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber,amount);
    }

    public Collection<Account> getAllAccounts() {
       return accountService.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }

    public void addInterest(){
        accountService.setInterest();
    }
}
