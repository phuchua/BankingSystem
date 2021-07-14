package common.services;


import common.models.Account;
import common.models.AccountEntry;
import common.models.Customer;
import common.observers.AccountCreateObserver;
import common.observers.AccountEntryObserver;
import common.repositories.AccountEntryRepository;
import common.repositories.AccountRepository;
import common.repositories.CustomerRepository;
import framework.RepositoryEvents;


public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	CustomerRepository customerRepository;
	AccountEntryRepository accountEntryRepository;

	public AccountServiceImpl(){
		accountRepository = new AccountRepository();
		accountRepository.addObserver(new AccountCreateObserver(), RepositoryEvents.POST_SAVE);
		customerRepository = new CustomerRepository();
		accountEntryRepository = new AccountEntryRepository();
		accountEntryRepository.addObserver(new AccountEntryObserver(),RepositoryEvents.POST_SAVE);
	}

	@Override
	public void createAccount(Account account, Customer customer) {
		Customer dbCustomer = customerRepository.loadOne(customer.getId());
		if(dbCustomer == null){
			customerRepository.save(customer);
		}else{
			customer = dbCustomer;
		}
		account.setCustomer(customer);
		accountRepository.save(account);
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

}
