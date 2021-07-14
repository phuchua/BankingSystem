package ui.ccard;

import ui.bank.AccountDialog;
import javax.swing.*;
import java.awt.event.*;

public class JDialog_AddCCAccount extends AccountDialog {
    private CardFrm cardFrame;

    public JDialog_AddCCAccount(CardFrm parent) {
        super(parent, "Add credit card account");
        cardFrame = parent;

        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36, 12, 84, 24);
        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36, 36, 84, 24);
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 108, 48, 24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 132, 48, 24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12, 156, 48, 24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12, 180, 48, 24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12, 204, 48, 24);
        JLabel6.setText("CC number");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 252, 96, 24);
        Label7.setText("Exp. Date");
        getContentPane().add(Label7);
        Label7.setForeground(java.awt.Color.black);
        Label7.setBounds(12, 276, 72, 24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(84, 108, 156, 20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(84, 156, 156, 20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(84, 180, 156, 20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(84, 132, 156, 20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(84, 204, 156, 20);
        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(84, 252, 156, 20);
        getContentPane().add(JTextField_ExpDate);
        JTextField_ExpDate.setBounds(84, 276, 156, 20);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48, 312, 84, 24);
        JButton_Cancel.setText("Cancel");
        JButton_Cancel.setActionCommand("Cancel");
        getContentPane().add(JButton_Cancel);
        JButton_Cancel.setBounds(156, 312, 84, 24);
        JRadioButton_Bronze.setText("Bronze");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36, 60, 84, 24);
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12, 228, 48, 24);
        getContentPane().add(JTextField_Email);
        JTextField_Email.setBounds(84, 228, 156, 20);
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);
    }

    JRadioButton JRadioButton_Gold = new JRadioButton();
    JRadioButton JRadioButton_Silver = new JRadioButton();
    JRadioButton JRadioButton_Bronze = new JRadioButton();
    JLabel JLabel1 = new JLabel();
    JLabel JLabel2 = new JLabel();
    JLabel JLabel3 = new JLabel();
    JLabel JLabel4 = new JLabel();
    JLabel JLabel5 = new JLabel();
    JLabel JLabel6 = new JLabel();
    JLabel Label7 = new JLabel();
    JTextField JTextField_NAME = new JTextField();
    JTextField JTextField_CT = new JTextField();
    JTextField JTextField_ST = new JTextField();
    JTextField JTextField_STR = new JTextField();
    JTextField JTextField_ZIP = new JTextField();
    JTextField JTextField_CCNR = new JTextField();
    JTextField JTextField_ExpDate = new JTextField();
    JButton JButton_OK = new JButton();
    JButton JButton_Cancel = new JButton();

    JLabel JLabel7 = new JLabel();
    JTextField JTextField_Email = new JTextField();

    @Override
    protected void okActionListener() {
        cardFrame.setCcNumber(JTextField_CCNR.getText());
        cardFrame.setExpDate(JTextField_ExpDate.getText());
    }

    class SymMouse extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            Object object = event.getSource();
            if (object == JRadioButton_Gold)
                JRadioButtonChk_mouseClicked(event);
            else if (object == JRadioButton_Silver)
                JRadioButtonSav_mouseClicked(event);
            else if (object == JRadioButton_Bronze)
                JRadioButtonBronze_mouseClicked(event);
        }
    }

    void JRadioButtonChk_mouseClicked(MouseEvent event) {
        JRadioButton_Gold.setSelected(true);
        JRadioButton_Silver.setSelected(false);
        JRadioButton_Bronze.setSelected(false);
    }

    void JRadioButtonSav_mouseClicked(MouseEvent event) {
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
    protected  void listenOptionalFields() {
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