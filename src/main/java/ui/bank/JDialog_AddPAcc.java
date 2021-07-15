package ui.bank;

import javax.swing.*;
import java.awt.event.*;

public class JDialog_AddPAcc extends AccountDialog {
    private JTextField JTextField_BD;
    private BankFrm bankFrame;
    public JDialog_AddPAcc(BankFrm parent) {
        super(parent, "Add Personal Account");
        bankFrame = parent;
        generateFields();
    }

    @Override
    protected void setUniqueFields() {
        JTextField_BD = new JTextField();
        displayAccountOptions();
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