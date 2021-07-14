package framework.oldfiles.core;

import framework.oldfiles.command.Command;
import framework.oldfiles.decorator.P1;
import framework.oldfiles.decorator.P2;
import framework.oldfiles.decorator.P3;
import framework.oldfiles.decorator.PromotionType;
import framework.oldfiles.factory.DataFactory;
import framework.oldfiles.factory.EnvironmentType;
import framework.oldfiles.factory.ProductionDAO;
import framework.oldfiles.factory.TestingDAO;
import framework.oldfiles.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;
	private DataFactory dataFactory;
	private List<Command> commands;
	private int undoRedoPosition = -1;

	public AccountServiceImpl(){
		//accountDAO = new AccountDAOImpl();
	}

	public AccountServiceImpl(EnvironmentType environmentType) {
		switch (environmentType) {
			case PRODUCTION:
				this.dataFactory = new ProductionDAO();
				break;
			case TESTING:
				this.dataFactory = new TestingDAO();
				break;
		}
		this.accountDAO = this.dataFactory.createAccountDAO();
		this.commands = new ArrayList<>();
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
		account.setInterestStrategy(accountType);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);

		accountDAO.saveAccount(account);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
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

	// added new assignPromotion method
	@Override
	public void assignPromotion(String accountNumber, PromotionType promotionType) {
		Account account = accountDAO.loadAccount(accountNumber);
		switch (promotionType) {
			case P1:
				account.setInterestStrategy(new P1(account.getInterestStrategy()));
				break;
			case P2:
				account.setInterestStrategy(new P2(account.getInterestStrategy()));
				break;
			case P3:
				account.setInterestStrategy(new P3(account.getInterestStrategy()));
				break;
		}
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
