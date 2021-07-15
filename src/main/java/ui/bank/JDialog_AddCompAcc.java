package ui.bank;


import javax.swing.*;
import java.awt.*;

public class JDialog_AddCompAcc extends AccountDialog {
    private BankFrm bankFrame;
    private JTextField JTextField_NoOfEmp = new JTextField();

    public JDialog_AddCompAcc(BankFrm parent) {
        super(parent, "Add Company Account");
        generateFields();
        bankFrame = parent;
    }

    @Override
    protected void setUniqueFields() {
        displayAccountOptions();
        JLabel6.setText("NoE");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);
        getContentPane().add(JTextField_NoOfEmp);
        JTextField_NoOfEmp.setBounds(84, 204, 156, 20);

        JLabel8.setText("Acc Nr");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(Color.black);
        JLabel8.setBounds(12, 228, 48, 24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(84, 228, 156, 20);
    }

    @Override
    protected void okActionListener() {
        bankFrame.setNoOfEmployees(JTextField_NoOfEmp.getText());
    }
}