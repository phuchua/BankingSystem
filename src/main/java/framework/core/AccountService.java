package framework.core;

import ccard.CreditCardType;
import banking.command.Command;
import framework.decorator.PromotionType;
import framework.strategy.InterestStrategy;

import java.time.LocalDate;
import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass,
                          String customerStreet, String customerCity, String customerState, String customerZip , String customerEmail );
    Account createPersonalAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass,
                                  String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, LocalDate birthdate);
    Account createCompanyAccount(String accountNumber, String customerName, InterestStrategy accountType, AccountClass accountClass,
                                 String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, int noOfEmployee);
    Account createCreditCard(String ccNumber, String customerName, InterestStrategy accountType, AccountClass accountClass,
                             String customerStreet, String customerCity, String customerState, String customerZip, String customerEmail, LocalDate expireDate, CreditCardType creditCardType);
    Account createAccount(String accountNumber, String customerName);
    Account createAccount(String accountNumber, String customerName, InterestStrategy accountType);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest ();
    void assignPromotion(String accountNumber, PromotionType promotionType);

    // lab05
    void addCommand(Command cmd);
    public void updateUndoRedoPosition(int undoRedoPosition);
    public int getUndoRedoPosition();
    public void undo();
    public void redo();
}
