package ui.bank;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
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
}
