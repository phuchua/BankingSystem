package ui.bank;

import banking.controllers.IAccountController;
import common.enums.AccountType;
import common.models.Account;
import framework.Controller;
import lombok.Getter;
import ui.common.JDialog_Deposit;
import ui.common.JDialog_Withdraw;

import javax.swing.*;
import java.awt.event.ActionListener;

@Getter
public abstract class BtnActions {
    private IAccountController controller;
    private MainFrame frame;

    public BtnActions(IAccountController controller, MainFrame frame) {
        this.controller = controller;
        this.frame = frame;
    }

    public final ActionListener exitWindow = event -> System.exit(0);

    public final ActionListener deposit = event -> {
        int selection = frame.getDataTable().getSelectionModel().getMinSelectionIndex();
        String accNo = getSelectedAccountNo(selection);
        if (accNo != null) {
            openDialog(new JDialog_Deposit(frame, accNo), 430, 15, 275, 140);
            double inpAmount = Double.parseDouble(frame.getAmountDeposit());
            controller.deposit(accNo, inpAmount);
            double newAmount = getCurrentBalance(accNo);
            frame.getDataTable().setValueAt(String.valueOf(newAmount), selection, balanceColumn());
        }
    };

    private double getCurrentBalance(String accNo) {
        Account account = controller.getAccountById(accNo);
        return account.getBalance();
    }

    private String getSelectedAccountNo(int selection) {
        if (selection >= 0)
            return (String) frame.getDataTable().getValueAt(selection, getAccountNoColumn());
        return null;
    }

    public final ActionListener withdraw = event -> {
        int selection = frame.getDataTable().getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accNo = getSelectedAccountNo(selection);
            openDialog(new JDialog_Withdraw(frame, accNo), 430, 15, 275, 140);
            long withdrawAmt = Long.parseLong(frame.getAmountDeposit());
            controller.withdraw(accNo, withdrawAmt);
            double newAmount = getCurrentBalance(accNo);
            frame.getDataTable().setValueAt(String.valueOf(newAmount), selection, balanceColumn());
            if (newAmount < 0) {
                JOptionPane.showMessageDialog(frame, " Account " +
                                accNo + " : balance is negative: $" + newAmount + " !",
                        "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }
    };

    protected abstract int balanceColumn();
    protected abstract int getAccountNoColumn();

    public final ActionListener applyInterest = event -> {
        JOptionPane.showMessageDialog(frame, "Add interest to all accounts",
                "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
        controller.addInterest();
        frame.updateAllTableRec(controller.getAllAccounts());
    };

    public void openDialog(JDialog jDialog) {
        openDialog(jDialog, 450, 20, 300, 330);
    }

    public void openDialog(JDialog jDialog, int x, int y, int width, int height) {
        jDialog.setBounds(x, y, width, height);
        jDialog.show();
    }

    protected AccountType getAccType(String accountType) {
        AccountType type = null;
        switch (accountType) {
            case "S":
                type = AccountType.SAVING;
                break;
            case "Ch":
                type = AccountType.CHECKING;
                break;
            default:
                break;
        }
        return type;
    }
}
