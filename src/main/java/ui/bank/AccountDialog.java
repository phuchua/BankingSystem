package ui.bank;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Setter
@Getter
public abstract class AccountDialog extends JDialog {
    private MainFrame parentFrame;
    JRadioButton JRadioButton_Chk = new JRadioButton();
    JRadioButton JRadioButton_Sav = new JRadioButton();
    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel JLabel6 = new JLabel();
    JLabel JLabel7 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_CT = new JTextField();
    JTextField JTextField_ST = new JTextField();
    JTextField JTextField_STR = new JTextField();
    JTextField JTextField_ZIP = new JTextField();
    JTextField JTextField_EM = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Cancel = new JButton();
    JLabel JLabel8 = new JLabel();
    JTextField JTextField_ACNR = new JTextField();

    public AccountDialog(MainFrame parent, String title) {
        super(parent);
        parentFrame = parent;

        setTitle(title);
        setModal(true);
        getContentPane().setLayout(null);
        setSize(283, 303);
        setVisible(false);
    }

    private void setCommonFields() {
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 60, 48, 24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 60, 156, 20);

        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 84, 48, 24);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(84, 84, 156, 20);

        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12, 108, 48, 24);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(84, 108, 156, 20);

        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12, 132, 48, 24);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(84, 132, 156, 20);

        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12, 156, 48, 24);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(84, 156, 156, 20);

        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(Color.black);
        JLabel7.setBounds(12, 180, 48, 24);
        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(84, 180, 156, 20);

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48, 276, 84, 24);

        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 276, 84, 24);

        JButton_OK.addActionListener(okAction);
        JButton_Cancel.addActionListener(cancelAction);
    }

    protected void generateFields () {
        setCommonFields();
        setUniqueFields();
    }

    protected abstract void setUniqueFields();

    protected final ActionListener okAction = event -> {
        parentFrame.setAccountNo(JTextField_ACNR.getText());
        parentFrame.setClientName(JTextField_NAME.getText());
        parentFrame.setStreet(JTextField_STR.getText());
        parentFrame.setCity(JTextField_CT.getText());
        parentFrame.setZip(JTextField_ZIP.getText());
        parentFrame.setStateAddress(JTextField_ST.getText());
        parentFrame.setCustomerEmail(JTextField_EM.getText());
        okActionListener();
        listenOptionalFields();
        parentFrame.setNewAccount(true);
        dispose();
    };

    protected final ActionListener cancelAction = event -> {
        dispose();
    };

    protected abstract void okActionListener();
    protected  void listenOptionalFields() {
        if (JRadioButton_Chk.isSelected())
            parentFrame.setAccountType("Ch");
        else
            parentFrame.setAccountType("S");
    }

    protected void displayAccountOptions() {
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(16, 22, 120, 24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(144, 22, 84, 24);
    }
}
