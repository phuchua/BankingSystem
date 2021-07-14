package banking;

import banking.command.Command;
import banking.command.DepositCommand;
import banking.command.TransferFundsCommand;
import banking.command.WithdrawCommand;
import framework.core.*;
import framework.factory.EnvironmentType;
import framework.strategy.CheckingsInterest;
import framework.strategy.SavingsInterest;
import java.time.LocalDate;

public class Application {

	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl(EnvironmentType.PRODUCTION);

		// add Personal account of Checking and Savings
		accountService.createPersonalAccount("1263862", "Personal Checking",
				new CheckingsInterest(), AccountClass.PERSONAL, "75 Pioneer Ranch",
				"Las Vegas", "Nevada", "98113",
				"frank@gmail.com", LocalDate.of(1985, 10, 5));
		accountService.createPersonalAccount("1234567", "Personal Savings",
				new SavingsInterest(), AccountClass.PERSONAL, "75 Pioneer Ranch",
				"Las Vegas", "Nevada", "98113",
				"frank@gmail.com", LocalDate.of(1985, 10, 5));
		accountService.createCompanyAccount("4253892", "Company Checking",
				new CheckingsInterest(), AccountClass.COMPANY, "80 Alexander Ave",
				"Iowa", "Nevada", "98113",
				"frank@gmail.com", 100);
		accountService.createCompanyAccount("7654321", "Company Savings",
				new SavingsInterest(), AccountClass.COMPANY, "80 Alexander Ave",
				"Iowa", "Nevada", "98113",
				"frank@gmail.com", 100);


		//accountService.createCreditCard("8473-8478-4829-8847", "Credit Card 1", AccountType, AccountClass.CREDITCARD,street,city,state,zip,email,expDate, creditCardType);

		// use account 1;
		//accountService.deposit("1263862", 240);
		//accountService.deposit("1263862", 529);
		//accountService.withdraw("1263862", 230);
		Command depositCommand = new DepositCommand(accountService, "1263862", 240);
		depositCommand.execute();
		//depositCommand = new DepositCommand(accountService, "1263862", 529);
		//depositCommand.execute();
		//depositCommand.undo();
		//depositCommand.redo();
		Command withdrawCommand = new WithdrawCommand(accountService, "1263862", 230);
		withdrawCommand.execute();

		// use account 2;
		//accountService.deposit("4253892", 12450);
		//accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		depositCommand = new DepositCommand(accountService, "4253892", 10000);
		depositCommand.execute();
		Command transferFundsCommand = new TransferFundsCommand(accountService, "4253892", "1263862", 500, "payment of invoice 10232");
		transferFundsCommand.execute();
		//transferFundsCommand = new TransferFundsCommand(accountService, "4253892", "1263862", 200, "payment of invoice 22222");
		//transferFundsCommand.execute();
		//transferFundsCommand.undo();

		// assign promotion
		//accountService.assignPromotion("1263862", PromotionType.P1);
		//accountService.assignPromotion("1263862", PromotionType.P2);
		//accountService.assignPromotion("4253892", PromotionType.P3);

		// calculate interest
		accountService.addInterest();

		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Account Type: " + account.getAccountType().getClass());
			
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
