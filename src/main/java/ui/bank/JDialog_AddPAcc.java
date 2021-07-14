package ui.bank;

import javax.swing.*;
import java.awt.event.*;

public class JDialog_AddPAcc extends AccountDialog {
    JTextField JTextField_BD = new JTextField();
    BankFrm bankFrame;
    public JDialog_AddPAcc(BankFrm parent) {
        super(parent, "Add Personal Account");
        bankFrame = parent;
        setUp();
    }

    void setUp() {
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36, 0, 84, 24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36, 24, 84, 24);
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 84, 48, 24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 108, 48, 24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12, 132, 48, 24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12, 156, 48, 24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12, 180, 48, 24);
        JLabel6.setText("Birthdate");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 204, 96, 24);
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12, 228, 48, 24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 84, 156, 20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(84, 132, 156, 20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(84, 156, 156, 20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(84, 108, 156, 20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(84, 180, 156, 20);
        getContentPane().add(JTextField_BD);
        JTextField_BD.setBounds(84, 204, 156, 20);
        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(84, 228, 156, 20);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(84, 60, 156, 20);
        JLabel8.setText("Acc Nr");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12, 60, 48, 24);

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