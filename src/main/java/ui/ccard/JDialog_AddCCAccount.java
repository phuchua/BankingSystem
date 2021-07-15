package ui.ccard;

import ui.bank.AccountDialog;

import javax.swing.*;
import java.awt.event.*;

public class JDialog_AddCCAccount extends AccountDialog {
    private CardFrm cardFrame;

    JRadioButton JRadioButton_Gold;
    JRadioButton JRadioButton_Silver;
    JRadioButton JRadioButton_Bronze;
    JTextField JTextField_CCNR;
    JTextField JTextField_ExpDate;

    public JDialog_AddCCAccount(CardFrm parent) {
        super(parent, "Add credit card account");
        cardFrame = parent;
        generateFields();
    }

    public void setUniqueFields() {
        JRadioButton_Gold = new JRadioButton();
        JRadioButton_Silver = new JRadioButton();
        JRadioButton_Bronze = new JRadioButton();
        JTextField_CCNR = new JTextField();
        JTextField_ExpDate = new JTextField();

        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checking");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(16, 22, 84, 24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(80, 22, 84, 24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(144, 22, 84, 24);

        getJLabel6().setText("CC number");
        getContentPane().add(getJLabel6());
        getJLabel6().setForeground(java.awt.Color.black);
        getJLabel6().setBounds(12, 204, 96, 24);
        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(84, 204, 156, 20);

        getJLabel7().setText("Exp. Date");
        getContentPane().add(getJLabel7());
        getJLabel7().setForeground(java.awt.Color.black);
        getJLabel7().setBounds(12, 228, 72, 24);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(84, 228, 156, 20);

        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);
    }

    @Override
    protected void okActionListener() {
        cardFrame.setCcNumber(JTextField_CCNR.getText());
        cardFrame.setExpDate(JTextField_ExpDate.getText());
    }

    class SymMouse extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            Object object = event.getSource();
            if (object == JRadioButton_Gold)
                checkingSelected(event);
            else if (object == JRadioButton_Silver)
                savingSelected(event);
            else if (object == JRadioButton_Bronze)
                JRadioButtonBronze_mouseClicked(event);
        }
    }

    void checkingSelected(MouseEvent event) {
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(false);
    }

    void savingSelected(MouseEvent event) {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(true);
        JRadioButton_Bronze.setSelected(false);

    }

    void JRadioButtonBronze_mouseClicked(MouseEvent event) {
        JRadioButton_Gold.setSelected(false);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(true);

    }

    @Override
    protected void listenOptionalFields() {
        if (JRadioButton_Gold.isSelected())
            cardFrame.setAccountType("Gold");
        else {
            if (JRadioButton_Silver.isSelected())
                cardFrame.setAccountType("Silver");
            else
                cardFrame.setAccountType("Bronze");
        }
    }
}