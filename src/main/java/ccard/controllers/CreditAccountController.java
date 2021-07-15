package ccard.controllers;

import ccard.enums.CreditCardType;
import ccard.factory.CreditCardFactory;
import ccard.services.CreditCardAccountServiceImpl;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;
import common.models.Customer;
import common.models.Person;
import framework.Controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class CreditAccountController implements Controller {
    CreditCardAccountServiceImpl accountService;

    public CreditAccountController() {
        accountService = new CreditCardAccountServiceImpl();
    }

    public Account createAccount(String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        UUID uuid = UUID.randomUUID();
        Customer person = new Person(uuid.toString(), name, street, city, state, zip, email, dob);
        uuid = UUID.randomUUID();

        Account account = CreditCardFactory.createCredCard(cardType, uuid.toString(), person);

        return accountService.createAccount(account, person);
    }


    public void deposit(String accountNumber, double amount) {
        accountService.deposit(accountNumber, amount);
    }


    public void withdraw(String accountNumber, double amount) {
        accountService.withdraw(accountNumber, amount);
    }

    public Collection<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    public Account getAccountById(String accountId) {
        return accountService.getAccountById(accountId);
    }


    public double getMinimumPayment(String accountNumber){
        return accountService.getMinimumPayment(accountNumber);
    }

    public Collection<AccountEntry>  getMonthlyBilling(String accountNumber) {
        return accountService.getMonthlyBilling(accountNumber);
    }

}
