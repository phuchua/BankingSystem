package banking;

import banking.command.Command;
import banking.command.DepositCommand;
import banking.command.TransferFundsCommand;
import banking.command.WithdrawCommand;
import framework.core.*;
import framework.core.Customer;
import framework.strategy.CheckingsInterest;
import framework.strategy.SavingsInterest;
import java.time.LocalDate;

public class Application {

	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();

		// add Personal account of Checking
		accountService.createPersonalAccount("1111111", "Personal Checking",
				new CheckingsInterest(), AccountClass.PERSONAL, "11 Pioneer Ranch",
				"Las Vegas", "Nevada", "98113",
				"customer1@gmail.com", LocalDate.of(1985, 10, 5));

		// add Personal account of Savings
		accountService.createPersonalAccount("2222222", "Personal Savings",
				new SavingsInterest(), AccountClass.PERSONAL, "22 Burlington",
				"Fairfield", "Iowa", "52556",
				"customer2@gmail.com", LocalDate.of(1985, 10, 5));

		// add Company account of Checking
		accountService.createCompanyAccount("3333333", "Company Checking",
				new CheckingsInterest(), AccountClass.COMPANY, "33 N 4th St",
				"Ottumwa", "Iowa", "52559",
				"customer3@gmail.com", 100);

		// add Company account of Savings
		accountService.createCompanyAccount("4444444", "Company Savings",
				new SavingsInterest(), AccountClass.COMPANY, "44 Martin Ave",
				"Des Moines", "Iowa", "52558",
				"customer4@gmail.com", 100);

		//accountService.createCreditCard("8473-8478-4829-8847", "Credit Card 1", AccountType, AccountClass.CREDITCARD,street,city,state,zip,email,expDate, creditCardType);

		// use account 1
		Command depositCommand = new DepositCommand(accountService, "1111111", 1000);
		depositCommand.execute();
		depositCommand = new DepositCommand(accountService, "1111111", 200);
		depositCommand.execute();
		//depositCommand.undo();
		//depositCommand.redo();
		Command withdrawCommand = new WithdrawCommand(accountService, "1111111", 300);
		withdrawCommand.execute();

		// use account 2
		depositCommand = new DepositCommand(accountService, "2222222", 2000);
		depositCommand.execute();
		//Command transferFundsCommand = new TransferFundsCommand(accountService, "2222222", "1111111", 700, "payment of invoice 100001");
		//transferFundsCommand.execute();
		//transferFundsCommand.undo();

		// use account 3
		depositCommand = new DepositCommand(accountService, "3333333", 300);
		depositCommand.execute();

		// use account 4
		depositCommand = new DepositCommand(accountService, "4444444", 400);
		depositCommand.execute();

		// calculate interest
		accountService.addInterest();

		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Account Type: " + account.getAccountType().getClass());

			System.out.println("-AccountNbr-----"
					+ "-Name---------------"
					+ "-City-----"
					+ "-P/C-----"
					+ "-Ch/S-------------------------------------"
					+ "-Amount------");

			System.out.printf("%15s%20s %5s%10s%45s%10s\n",
					account.getAccountNumber(),
					customer.getName(),
					customer.getCity(),
					account.getAccountClass(),
					account.getAccountType().getClass(),
					account.getBalance());

			System.out.println("-------------------------------------------------------" + "-------------------------------------------------------");

			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n",
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}
	}

}
