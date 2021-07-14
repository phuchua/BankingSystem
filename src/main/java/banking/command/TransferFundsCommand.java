package banking.command;

import common.services.AccountService;

public class TransferFundsCommand implements Command {

    AccountService accountService;
    String fromAccountNumber;
    String toAccountNumber;
    String description;
    double amount;

    public TransferFundsCommand(AccountService accountService, String fromAccountNumber, String toAccountNumber, double amount, String description) {
        this.accountService = accountService;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public void execute() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
        this.accountService.addCommand(this);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }

    @Override
    public void undo() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, -amount, description);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index - 1);
    }

    @Override
    public void redo() {
        accountService.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
        int index = this.accountService.getUndoRedoPosition();
        this.accountService.updateUndoRedoPosition(index + 1);
    }

}
