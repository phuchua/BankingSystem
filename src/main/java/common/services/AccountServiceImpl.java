package common.services;


import common.models.Account;
import common.models.Customer;
import common.observers.AccountCreateObserver;
import common.repositories.AccountRepository;
import common.repositories.CustomerRepository;
import framework.EventType;
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
		Customer dbCustomer = accountRepository.loadOne(customer.getId());
		if(dbCustomer == null){
			customerRepository.save(customer);
		}else{
			customer = dbCustomer;
		}
		account.setCustomer(customer);
		accountRepository.save(account);
	}
}
