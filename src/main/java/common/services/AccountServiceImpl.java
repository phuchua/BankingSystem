package common.services;


import common.models.Account;
import common.models.Customer;
import common.observers.AccountCreateObserver;
import common.repositories.AccountRepository;
import common.repositories.CustomerRepository;
import framework.RepositoryEvents;


public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	CustomerRepository customerRepository;

	public AccountServiceImpl(){
		accountRepository = new AccountRepository();
		accountRepository.addObserver(new AccountCreateObserver(), RepositoryEvents.POST_SAVE);
		customerRepository = new CustomerRepository();
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

		account.deposit(amount, "Deposit");
		accountRepository.update(account);
	}

	@Override
	public void withdraw(String accountNumber, double amount) {

		Account account = accountRepository.loadOne(accountNumber);
		if(account == null){
			throw new IllegalArgumentException();
		}

		account.deposit(amount, "Withdraw");
		accountRepository.update(account);
	}

	@Override
	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountRepository.loadOne(fromAccountNumber);
		Account toAccount = accountRepository.loadOne(toAccountNumber);

		if(fromAccount == null || toAccount == null){
			throw new IllegalArgumentException();
		}

		fromAccount.withdraw(amount, description);
		fromAccount.deposit(amount, description);

		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

	}
}
