package banking.services;


import banking.command.Command;
import banking.strategy.BasicAccountInterestStrategy;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	CustomerRepository customerRepository;
	AccountEntryRepository accountEntryRepository;
	private List<Command> commands;
	private int undoRedoPosition = -1;

	// Singleton instance
	private static AccountServiceImpl instance;

	public static AccountServiceImpl getInstance() {
		if (instance == null) {
			instance = new AccountServiceImpl();
		}
		return instance;
	}

	public AccountServiceImpl(){
		accountRepository = new AccountRepository();
		accountRepository.addObserver(new AccountUpdateObserver(),RepositoryEvents.POST_UPDATE);
		customerRepository = new CustomerRepository();
		accountEntryRepository = new AccountEntryRepository();
		accountEntryRepository.addObserver(new AccountEntryObserver(),RepositoryEvents.POST_SAVE);
		this.commands = new ArrayList<>();
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
		account.setInterestStrategy(new BasicAccountInterestStrategy());
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
	public Account getAccount(String accountNumber) {
		Account account = accountRepository.loadOne(accountNumber);
		return account;
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
		Collection<Account> accounts = this.accountRepository.getAll();
		accounts.forEach(account ->{
			account.addInterest();
		});
		//this.deposit(account.getId(),account.getInterestStrategy().calculateInterest(account.getBalance()));
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.loadOne(fromAccountNumber);
		Account toAccount = accountRepository.loadOne(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);
	}

	public void addCommand(Command cmd){
		commands.add(cmd);
	}

	public void updateUndoRedoPosition(int undoRedoPosition){
		this.undoRedoPosition = undoRedoPosition;
	}

	public int getUndoRedoPosition() {
		return undoRedoPosition;
	}

	public void undo(){
		this.commands.get(undoRedoPosition).undo();
	}

	public void redo(){
		this.commands.get(undoRedoPosition + 1).redo();
	}
}
