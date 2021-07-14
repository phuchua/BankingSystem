package framework.oldfiles.command;

import framework.oldfiles.core.AccountService;

public class WithdrawCommand implements Command {

    private AccountService accountService;
    private String accountNumber;
    private double amount;

    public WithdrawCommand(AccountService service, String accountNumber, double amount) {
        this.accountService = service;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.withdraw(accountNumber, amount);
        this.accountService.addCommand(this);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }

    @Override
    public void undo() {
        accountService.withdraw(accountNumber, -amount);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index - 1);
    }

    @Override
    public void redo() {
        accountService.withdraw(accountNumber, amount);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }
}
