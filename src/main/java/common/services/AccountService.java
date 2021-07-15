package common.services;


import banking.command.Command;
import common.models.Account;
import common.models.Customer;
import framework.Service;

import java.util.Collection;

public interface AccountService extends Service {
    Account createAccount(Account account, Customer customer);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    Account getAccountById(String accountId);
    void setInterest();
    void addCommand(Command cmd);
    public void updateUndoRedoPosition(int undoRedoPosition);
    public int getUndoRedoPosition();
    public void undo();
    public void redo();
}
