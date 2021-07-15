package ui.bank;

import javax.swing.*;
import java.awt.event.*;

public class JDialog_AddPAcc extends AccountDialog {
    JTextField JTextField_BD;
    BankFrm bankFrame;
    public JDialog_AddPAcc(BankFrm parent) {
        super(parent, "Add Personal Account");
        bankFrame = parent;
        generateFields();
    }

    @Override
    protected void setUniqueFields() {
        JTextField_BD = new JTextField();
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36, 0, 84, 24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36, 24, 84, 24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(84, 228, 156, 20);
        JLabel8.setText("Acc Nr");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12, 228, 48, 24);

        JLabel6.setText("Birthdate");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);

        getContentPane().add(JTextField_BD);
        JTextField_BD.setBounds(84, 204, 156, 20);

        JRadioButton_Chk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JRadioButton_Chk.setSelected(true);
                JRadioButton_Sav.setSelected(false);
            }
        });
        JRadioButton_Sav.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JRadioButton_Chk.setSelected(false);
                JRadioButton_Sav.setSelected(true);
            }
        });
    }

    @Override
    protected void okActionListener() {
        bankFrame.setBirthDate(JTextField_BD.getText());
    }
}