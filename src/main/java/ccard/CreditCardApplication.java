package ccard;


import ccard.controllers.CreditAccountController;
import ccard.enums.CreditCardType;
import common.enums.AccountType;
import common.models.Account;
import common.models.AccountEntry;

import java.time.LocalDate;
import java.util.Collection;

public class CreditCardApplication {

    public static void main(String[] args) {
        CreditAccountController creditAccountController = new CreditAccountController();
        LocalDate dob = LocalDate.now();
        Account creditAccount = creditAccountController.createAccount("","Salah", "street", "City", "IA", "52556", "salah.khudairat@gmail.com", dob, AccountType.CREDIT, CreditCardType.GOLD);


        creditAccountController.deposit(creditAccount.getId(), 100);
        creditAccountController.deposit(creditAccount.getId(), 500);
        creditAccountController.withdraw(creditAccount.getId(), 1000);
        creditAccount = creditAccountController.getAccountById(creditAccount.getId());
        System.out.println("Credit Account");

        double currentBalance = creditAccount.getBalance();
        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Minimum Payment " + creditAccountController.getMinimumPayment(creditAccount.getId()));
        Collection<AccountEntry> accountEntries = creditAccountController.getMonthlyBilling(creditAccount.getId());
        for (AccountEntry entry :
                accountEntries) {
            System.out.println( entry.getAmount());
        }
    }

}
