package banking.controllers;

import ccard.enums.CreditCardType;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;
import framework.Controller;
import ccard.enums.CreditCardType;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;

import java.time.LocalDate;
import java.util.Collection;

import java.time.LocalDate;
import java.util.Collection;

public interface IAccountController extends Controller {
    public  void deposit(String accountNumber, double amount);

    public  void withdraw(String accountNumber, double amount);

    public  Collection<Account> getAllAccounts();

    public  Account getAccountById(String accountId);

    default public double getMinimumPayment(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    default public Account createAccount(String cc, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        throw new UnsupportedOperationException();
    }

    default public Account createPersonalAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType) {
        throw new UnsupportedOperationException();
    }

    default public Account createCompanyAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType) {
        throw new UnsupportedOperationException();
    }
    default public void addInterest(){
        throw new UnsupportedOperationException();
    }
}
