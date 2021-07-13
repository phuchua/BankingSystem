package framework.core;

import framework.observer.EmailSender;
import framework.observer.Logger;
import framework.observer.SMSSender;
import framework.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

public class Account extends Observable {
	private Customer customer;
	private String accountNumber;

	// added code here for Lab02
	private Logger logger = new Logger();
	private SMSSender smsSender = new SMSSender();
	private EmailSender emailSender = new EmailSender();

	public void notifyAllObservers() {
		setChanged();
		notifyObservers();
	}

	// added code here for Lab01
	private InterestStrategy interestStrategy;

	public InterestStrategy getInterestStrategy() {
		return interestStrategy;
	}

	public void setInterestStrategy(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
	}

	public void addInterest(){
		double balance = getBalance();
		double amount = interestStrategy.computeInterest(balance);
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
