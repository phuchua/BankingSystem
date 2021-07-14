package banking.controllers;

import common.enums.AccountType;
import common.models.Account;
import common.models.Company;
import common.models.Customer;
import common.models.Person;
import common.services.AccountService;
import common.services.AccountServiceImpl;

import java.util.Date;
import java.util.UUID;

public class AccountController {

    public AccountController(){
        accountService = new AccountServiceImpl();
    }

    AccountService accountService;

    public void createPersonalAccount(String name, String street, String city, String state, String zip, String email, Date dob, AccountType accountType){
       Customer person = new Person(name,street,city,state,zip,email,dob);
       UUID uuid = UUID.randomUUID();
       Account account = new Account(uuid.toString(),person,accountType);
       accountService.createAccount(account,person);
    }

    public void createCompanyAccount(String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType){
        Customer company = new Company(name,street,city,state,zip,email,numberOfEmployees);
        UUID uuid = UUID.randomUUID();
        Account account = new Account(uuid.toString(),company,accountType);
        accountService.createAccount(account,company);
    }
}
