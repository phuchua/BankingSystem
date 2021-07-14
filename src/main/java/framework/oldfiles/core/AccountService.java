package framework.oldfiles.core;

import framework.oldfiles.command.Command;
import framework.oldfiles.decorator.PromotionType;
import framework.oldfiles.strategy.InterestStrategy;

import java.util.Collection;

public interface AccountService {
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
