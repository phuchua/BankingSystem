package ui.bank;

import banking.controllers.AccountController;
import common.models.Account;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collection;

@Setter
@Getter
public class BankFrm extends MainFrame {
    private BankBtnActions btnActions;
    private String birthDate;
    private String noOfEmployees;

    public BankFrm() {
        setFrame(this);
        setBtnActions(new BankBtnActions(new AccountController(), this));
        overview("Bank Application.", Arrays.asList("AccountNr", "Name", "City", "P/C", "Ch/S", "Amount"), getButtons());
    }

    public static void main(String args[]) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            (new BankFrm()).setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    void exitApplication() {
        try {
            this.setVisible(false);
            this.dispose();
            System.exit(0);
        } catch (Exception e) {
        }
    }

    public void updateTable(Account account) {
        if (isNewAccount()) {
            changeTableContent(account.getId(), account.getCustomer().getName(), account.getCustomer().getCity(), account.getCustomer().getCustomerType().name(), account.getAccountType().name(), Double.toString(account.getBalance()));
            setNewAccount(false);
        }
    }

    @Override
    public void windowListeners() {
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
    }

    class SymWindow extends WindowAdapter {
        public void windowClosing(WindowEvent event) {
            Object object = event.getSource();
            if (object == BankFrm.this)
                BankFrm_windowClosing(event);
        }
    }

    void BankFrm_windowClosing(WindowEvent event) {
        BankFrm_windowClosing_Interaction1(event);
    }

    void BankFrm_windowClosing_Interaction1(WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    private Collection<JButton> getButtons() {
        return Arrays.asList(
                new AccountButton("Add personal account", getBtnActions().addPersonalAccount, 24, 20, 192, 33),
                new AccountButton("Add company account", getBtnActions().addBusinessAccount, 240, 20, 192, 33),
                new AccountButton("Deposit", getBtnActions().deposit, 468, 104, 96, 33),
                new AccountButton("Withdraw", getBtnActions().withdraw, 448, 20, 106, 33),
                new AccountButton("Add interest", getBtnActions().applyInterest, 468, 164, 96, 33),
                new AccountButton("Exit", getBtnActions().exitWindow, 468, 248, 96, 31)
        );
    }
}
