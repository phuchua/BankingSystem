package framework.command;

import framework.core.AccountService;

public class DepositCommand implements Command {
    AccountService accountService;
    String accountNumber;
    double amount;

    public  DepositCommand(AccountService accountService, String accountNumber, double amount) {
        this.accountService = accountService;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.deposit(this.accountNumber, this.amount);
        this.accountService.addCommand(this);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }

    @Override
    public void undo() {
        accountService.deposit(accountNumber, -amount);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index - 1);
    }

    @Override
    public void redo() {
        accountService.deposit(accountNumber, amount);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }
}
