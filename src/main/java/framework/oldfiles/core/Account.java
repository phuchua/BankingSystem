package framework.core;

import ccard.CreditCardStrategy;
import ccard.CreditCardType;
import framework.observer.EmailSender;
import framework.observer.Logger;
import framework.observer.SMSSender;
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

	// added code here for Lab02
	protected Logger logger = new Logger();
	protected SMSSender smsSender = new SMSSender();
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

	public void addInterest(){
		double balance = getBalance();
		double amount = accountType.calculateInterest(balance);
		AccountEntry entry = new AccountEntry(amount, "interest", "", "");
		entryList.add(entry);
		measurementsChanged(false);
	}
	// end added

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.addObserver(emailSender);
		measurementsChanged(true);
	}

	public Account(String accountNumber, InterestStrategy accountType, AccountClass accountClass) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountClass = accountClass;
		this.creditCardStrategy = null;
		this.addObserver(emailSender);
		measurementsChanged(true);
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
		measurementsChanged(false);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		entryList.add(entry);
		measurementsChanged(false);
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
		measurementsChanged(false);
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

	// Changed for balance then trigger logger and smsSender or creating account then trigger email
	private void measurementsChanged(boolean isEmail) {
		if (isEmail) {
			this.addObserver(emailSender);
		} else {
			this.addObserver(smsSender);
			this.addObserver(logger);
		}
		notifyAllObservers();
		if (isEmail) {
			this.deleteObserver(emailSender);
		} else {
			this.deleteObserver(smsSender);
			this.deleteObserver(logger);
		}
	}
}
