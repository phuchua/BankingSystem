package banking;


import banking.controllers.AccountController;
import common.enums.AccountType;
import common.models.Account;

import java.time.LocalDate;


public class Application {

	public static void main(String[] args) {
		AccountController accountController = new AccountController();
		LocalDate dob = LocalDate.now();
		Account pAccount  = accountController.createPersonalAccount("Salah","street","City","IA","52556","salah.khudairat@gmail.com",dob, AccountType.CHECKING);
		accountController.deposit(pAccount.getId(),100);
		accountController.deposit(pAccount.getId(),500);
		accountController.withdraw(pAccount.getId(),1000);
		pAccount= accountController.getAccountById(pAccount.getId());

		System.out.println("Balance "+pAccount.getBalance());
	}

}
