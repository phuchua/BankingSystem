package banking;

import framework.oldfiles.command.Command;
import framework.oldfiles.command.DepositCommand;
import framework.oldfiles.command.TransferFundsCommand;
import framework.oldfiles.command.WithdrawCommand;
import framework.oldfiles.core.*;
import framework.oldfiles.decorator.PromotionType;
import framework.oldfiles.factory.EnvironmentType;
import framework.oldfiles.strategy.CheckingsInterest;
import framework.oldfiles.strategy.SavingsInterest;

public class Application {

	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl(EnvironmentType.PRODUCTION);

		// create 2 accounts;
		accountService.createAccount("1263862", "Frank Brown", new CheckingsInterest());
		accountService.createAccount("4253892", "John Doe", new SavingsInterest());

		// use account 1;
		//accountService.deposit("1263862", 240);
		//accountService.deposit("1263862", 529);
		//accountService.withdraw("1263862", 230);
		Command depositCommand = new DepositCommand(accountService, "1263862", 240);
		depositCommand.execute();
		depositCommand = new DepositCommand(accountService, "1263862", 529);
		depositCommand.execute();
		depositCommand.undo();
		depositCommand.redo();
		Command withdrawCommand = new WithdrawCommand(accountService, "1263862", 230);
		withdrawCommand.execute();

		// use account 2;
		//accountService.deposit("4253892", 12450);
		//accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		depositCommand = new DepositCommand(accountService, "4253892", 12450);
		depositCommand.execute();
		Command transferFundsCommand = new TransferFundsCommand(accountService, "4253892", "1263862", 100, "payment of invoice 10232");
		transferFundsCommand.execute();
		transferFundsCommand = new TransferFundsCommand(accountService, "4253892", "1263862", 200, "payment of invoice 22222");
		transferFundsCommand.execute();
		transferFundsCommand.undo();

		// assign promotion
		accountService.assignPromotion("1263862", PromotionType.P1);
		accountService.assignPromotion("1263862", PromotionType.P2);
		accountService.assignPromotion("4253892", PromotionType.P3);

		// calculate interest
		accountService.addInterest();

		// show balances
		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Account Type: " + account.getInterestStrategy().getClass());
			
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
