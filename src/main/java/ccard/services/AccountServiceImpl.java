package ccard.services;


import banking.command.Command;
import ccard.strategy.GoldCCInterestStrategy;
import common.models.Account;
import common.models.AccountEntry;
import common.models.Customer;
import common.observers.AccountEntryObserver;
import common.observers.AccountUpdateObserver;
import common.repositories.AccountEntryRepository;
import common.repositories.AccountRepository;
import common.repositories.CustomerRepository;
import common.services.AccountService;
import framework.RepositoryEvents;

import java.util.Collection;


public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	CustomerRepository customerRepository;
	AccountEntryRepository accountEntryRepository;

	public AccountServiceImpl(){
		accountRepository = new AccountRepository();
		accountRepository.addObserver(new AccountUpdateObserver(),RepositoryEvents.POST_UPDATE);
		customerRepository = new CustomerRepository();
		accountEntryRepository = new AccountEntryRepository();
		accountEntryRepository.addObserver(new AccountEntryObserver(),RepositoryEvents.POST_SAVE);
	}

	@Override
	public Account createAccount(Account account, Customer customer) {
		Customer dbCustomer = customerRepository.loadOne(customer.getId());
		if(dbCustomer == null){
			customerRepository.save(customer);
		}else{
			customer = dbCustomer;
		}
		account.setCustomer(customer);
		account.setInterestStrategy(new GoldCCInterestStrategy());
		accountRepository.save(account);
		return account;
	}

	@Override
	public void deposit(String accountNumber, double amount) {
		Account account = accountRepository.loadOne(accountNumber);
		if(account == null){
			throw new IllegalArgumentException();
		}

		AccountEntry entry = new AccountEntry(amount, "Deposit", accountNumber, "");
		entry.setAccount(account);
		accountEntryRepository.save(entry);
		account.addEntry(entry);
		accountRepository.update(account);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		Account account = accountRepository.loadOne(accountNumber);
		if(account == null){
			throw new IllegalArgumentException();
		}

		AccountEntry entry = new AccountEntry(-amount, "Withdraw", accountNumber, "");
		entry.setAccount(account);
		accountEntryRepository.save(entry);
		account.addEntry(entry);
		accountRepository.update(account);
	}

	@Override
	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {

	}

	@Override
	public Account getAccount(String accountNumber) {
		return null;
	}

	@Override
	public Collection<Account> getAllAccounts() {
		return this.accountRepository.getAll();
	}

	@Override
	public Account getAccountById(String accountId) {
		return this.accountRepository.loadOne(accountId);
	}

	@Override
	public void setInterest() {
		for(Account account: this.accountRepository.getAll()){
			//this.deposit();
		}
	}

	@Override
	public void addCommand(Command cmd) {

	}

	@Override
	public void updateUndoRedoPosition(int undoRedoPosition) {

	}

	@Override
	public int getUndoRedoPosition() {
		return 0;
	}

	@Override
	public void undo() {

	}

	@Override
	public void redo() {

	}


}
