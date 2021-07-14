package framework.core;

import ccard.CreditCardStrategy;
import ccard.CreditCardType;
import framework.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

public class Account extends Observable {
	protected Customer customer;
	protected String accountNumber;
	protected InterestStrategy accountType;
	protected AccountClass accountClass;
	protected CreditCardStrategy creditCardStrategy;
	protected CreditCardType creditCardType;
	protected EmailSender emailSender = new EmailSender();

	public void notifyAllObservers() {
		setChanged();
		notifyObservers();
	}

	public InterestStrategy getAccountType() {
		return accountType;
	}

	public void setAccountType(InterestStrategy accountType) {
		this.accountType = accountType;
	}

	public AccountClass getAccountClass() {
		return accountClass;
	}

	public void addInterest(){
		double balance = getBalance();
		double amount = accountType.calculateInterest(balance);
		AccountEntry entry = new AccountEntry(amount, "interest", "", "");
	}

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account(String accountNumber, InterestStrategy accountType, AccountClass accountClass) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountClass = accountClass;
		this.creditCardStrategy = null;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
		balanceChanged();
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
		balanceChanged();
	}

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		
		entryList.add(fromEntry);
		toAccount.addEntry(toEntry);
		balanceChanged();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	private void balanceChanged() {
		this.addObserver(emailSender);
		notifyAllObservers();
		this.deleteObserver(emailSender);
	}
}