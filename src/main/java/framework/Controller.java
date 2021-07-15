package framework;

import ccard.enums.CreditCardType;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;

import java.time.LocalDate;
import java.util.Collection;

public abstract class Controller {
    public abstract void deposit(String accountNumber, double amount);

    public abstract void withdraw(String accountNumber, double amount);

    public abstract Collection<Account> getAllAccounts();

    public abstract Account getAccountById(String accountId);

    public double getMinimumPayment(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    public Collection<AccountEntry> getMonthlyBilling(String accountNumber) {
        throw new UnsupportedOperationException();
    }

    public Account createAccount(String cc, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType, CreditCardType cardType) {
        throw new UnsupportedOperationException();
    }

    public Account createPersonalAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dob, AccountType accountType) {
        throw new UnsupportedOperationException();
    }

    public Account createCompanyAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, AccountType accountType) {
        throw new UnsupportedOperationException();
    }
    public void addInterest(){
        throw new UnsupportedOperationException();
    }
}


