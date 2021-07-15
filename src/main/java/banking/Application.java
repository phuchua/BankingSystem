package banking;


import banking.controllers.AccountController;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;
import common.models.Customer;

import java.time.LocalDate;
import java.util.Date;

public class Application {

	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		Date dob = new Date();
		accountController.createPersonalAccount("1111111","Personal Checking","1 Pioneer Ranch","Las Vegas","Nevada","98113","customer1@gmail.com", LocalDate.of(1985, 10, 5), AccountType.CHECKING);
		accountController.createPersonalAccount("2222222","Personal Savings","2 Burlington","Fairfield","Iowa","52556","customer2@gmail.com", LocalDate.of(1983, 12, 1), AccountType.SAVING);
		accountController.createCompanyAccount("3333333","Company Checking","customer3@gmail.com","3 N 4th St","Ottumwa","Iowa","52559", 30, AccountType.SAVING);
		accountController.createCompanyAccount("4444444","Company Saving","customer4@gmail.com","4 Martin Ave","Des Moines","Iowa","53777", 20, AccountType.CHECKING);

		accountController.deposit("1111111",1000);
		accountController.withdraw("1111111",600);

		accountController.deposit("2222222",400);
		accountController.deposit("3333333",300);
		accountController.deposit("3333333",400);
		accountController.deposit("4444444",400);

		accountController.addInterest();

		for (Account account : accountController.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getId());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("Account Type: " + account.getAccountType().toString());

			System.out.println("-AccountNbr------"
					+ "-Name-------------------"
					+ "-City-------------"
					+ "-P/C--------------"
					+ "-Ch/S------------------"
					+ "-Amount---------");

			System.out.printf("%15s%20s %15s%10s%25s%20s\n",
					account.getId(),
					customer.getName(),
					customer.getCity(),
					account.getCustomer().getCustomerType(),
					account.getAccountType().toString(),
					account.getBalance());

			System.out.println("----------------------------------------------------------" + "----------------------------------------------------------");

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
