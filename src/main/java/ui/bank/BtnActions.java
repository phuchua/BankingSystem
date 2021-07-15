package ui.bank;


import common.services.AccountService;
import common.strategy.InterestStrategy;
import ui.common.JDialog_Deposit;
import ui.common.JDialog_Withdraw;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BtnActions {
    private AccountService accountService;
    private MainFrame frame;

    public BtnActions(AccountService accountService, MainFrame frame) {
        this.accountService = accountService;
        this.frame = frame;
    }

    public final ActionListener exitWindow = event -> System.exit(0);

    public final ActionListener deposit = event -> {
        int selection = frame.getDataTable().getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accNo = (String) frame.getDataTable().getValueAt(selection, 0);
            openDialog(new JDialog_Deposit(frame, accNo), 430, 15, 275, 140);
            long depositInp = Long.parseLong(frame.getAmountDeposit());
            String sAmount = (String) frame.getDataTable().getValueAt(selection, 5);
            long currentAmount = Long.parseLong(sAmount);
            long newAmount = currentAmount + depositInp;
            frame.getDataTable().setValueAt(String.valueOf(newAmount), selection, 5);
        }
    };

    public final ActionListener withdraw = event -> {
        int selection = frame.getDataTable().getSelectionModel().getMinSelectionIndex();
        if (selection >= 0) {
            String accNo = (String) frame.getDataTable().getValueAt(selection, 0);
            openDialog( new JDialog_Withdraw(frame, accNo),430, 15, 275, 140);
            String sAmount = (String) frame.getDataTable().getValueAt(selection, 5);
            long currentAmount = Long.parseLong(sAmount);
            long depositInp = Long.parseLong(frame.getAmountDeposit());
            long newAmount = currentAmount - depositInp;
            frame.getDataTable().setValueAt(String.valueOf(newAmount), selection, 5);
            if (newAmount < 0) {
                JOptionPane.showMessageDialog(frame, " Account " +
                                accNo + " : balance is negative: $" + newAmount + " !",
                        "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
            }
        }
    };

    public final ActionListener applyInterest = event -> JOptionPane.showMessageDialog(frame, "Add interest to all accounts",
            "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);

    public void openDialog(JDialog jDialog){
        openDialog(jDialog, 450, 20, 300, 330);
    }
    public void openDialog(JDialog jDialog, int x, int y, int width, int height){
        jDialog.setBounds(x, y, width, height);
        jDialog.show();
    }
/*
    private InterestStrategy getAccStrategy(String accountType) {
        InterestStrategy strategy = null;
        switch (accountType) {
            case "P": strategy = new CheckingsInterest(); break;
            case "CREDITCARD": strategy = new CreditCardInterest(); break;
            case "C": strategy = new SavingsInterest(); break;
            default: break;
        }
        return strategy;
    }

    private AccountClass getAccType(String accountType) {
        AccountClass type = null;
        switch (accountType) {
            case "P": type = PERSONAL; break;
            case "COMPANY": type = COMPANY; break;
            case "CREDITCARD": type = CREDITCARD; break;
            default: break;
        }
        return type;
    }*/
}
