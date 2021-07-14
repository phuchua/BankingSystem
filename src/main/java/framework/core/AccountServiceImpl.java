package framework.core;

import ccard.CreditCardType;
import banking.command.Command;
import framework.strategy.InterestStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private List<Command> commands;
	private int undoRedoPosition = -1;
	private CustomerDAO customerDAO;

	public AccountServiceImpl() {
		this.accountDAO = new AccountDAOImpl();
		this.commands = new ArrayList<>();
		customerDAO = new CustomerDAOImpl();
	}

	@Override
	public Account createAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass, String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);
		account.addObserver(new EmailSender());

		return account;
	}

	@Override
	public Account createPersonalAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass, String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, LocalDate birthdate) {
		Account account = new Account(accountNumber, accountType, AccountClass.PERSONAL);

		Customer customer = customerDAO.getCustomerList().stream()
				.filter(x -> x.getName().equals(customerName))
				.findFirst()
				.orElse(null);
		if (customer == null)
			customer = new Customer(customerName, customerEmail, customerStreet, customerCity, customerState, customerZip);

		account.setCustomer(customer);
		customer.setBirthday(birthdate);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);
		customerDAO.saveCustomer(customer);
		account.addObserver(new EmailSender());

		return account;
	}

	@Override
	public Account createCompanyAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass, String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, int noOfEmployee) {
		Account account = new Account(accountNumber, accountType, AccountClass.COMPANY);

		Customer customer = customerDAO.getCustomerList().stream()
				.filter(x -> x.getName().equals(customerName))
				.findFirst()
				.orElse(null);
		if (customer == null)
			customer = new Customer(customerName, customerEmail, customerStreet, customerCity, customerState, customerZip);

		account.setCustomer(customer);
		customer.setNoOfEmployee(noOfEmployee);

		accountDAO.saveAccount(account);
		customerDAO.saveCustomer(customer);
		account.addObserver(new EmailSender());

		return account;
	}

	@Override
	public Account createCreditCard(String ccNumber, String customerName, InterestStrategy accountType, AccountClass accountClass, String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, LocalDate expireDate, CreditCardType creditCardType) {
		return null;
	}

	public Account createAccount(String accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		
		accountDAO.saveAccount(account);
		
		return account;
	}

	// added new createAccount method
	public Account createAccount(String accountNumber, String customerName, InterestStrategy accountType) {
		Account account = new Account(accountNumber);
		account.setAccountType(accountType);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);
		account.addObserver(new EmailSender());
		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		account.addObserver(new EmailSender());
		accountDAO.updateAccount(account);
	}

	public Account getAccount(String accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		account.addObserver(new EmailSender());
		accountDAO.updateAccount(account);
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	// added new addInterest method
	public void addInterest (){
		Collection<Account> accounts = getAllAccounts();
		accounts.forEach(account ->{
			account.addInterest();
		});
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
