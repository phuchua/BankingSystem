package banking.controllers;

import banking.services.AccountServiceImpl;
import common.enums.AccountType;
import common.models.Account;
import common.models.Company;
import common.models.Customer;
import common.models.Person;
import common.services.AccountService;
import framework.Controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class AccountController extends Controller {
    AccountService accountService;

    public AccountController(){
        accountService = AccountServiceImpl.getInstance();
    }

    public Account createPersonalAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType){
       UUID uuid = UUID.randomUUID();
       Customer person = new Person(uuid.toString(),name,street,city,state,zip,email,dob);
       Account account = new Account(accountNumber,person,accountType);
       return accountService.createAccount(account,person);
    }

    public Account createCompanyAccount(String accountNumber,String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType){
        UUID uuid = UUID.randomUUID();
        Customer company = new Company(uuid.toString(),name,street,city,state,zip,email,numberOfEmployees);
        Account account = new Account(accountNumber,company,accountType);
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
