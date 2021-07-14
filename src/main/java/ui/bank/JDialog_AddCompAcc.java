package ui.bank;


import javax.swing.*;

public class JDialog_AddCompAcc extends AccountDialog {
    private BankFrm bankFrame;
    private JTextField JTextField_NoOfEmp = new JTextField();

    public JDialog_AddCompAcc(BankFrm parent) {
        super(parent, "Add Company Account");
        setUp();
        bankFrame = parent;
    }

    public void setUp() {
        JRadioButton_Chk.setText("Checkings");
        JRadioButton_Chk.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Chk);
        JRadioButton_Chk.setBounds(36, 12, 84, 24);
        JRadioButton_Sav.setText("Savings");
        JRadioButton_Sav.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Sav);
        JRadioButton_Sav.setBounds(36, 36, 84, 24);
        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12, 96, 48, 24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12, 120, 48, 24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12, 144, 48, 24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12, 168, 48, 24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12, 192, 48, 24);
        JLabel6.setText("No of employees");
        getContentPane().add(JLabel6);
        JLabel6.setForeground(java.awt.Color.black);
        JLabel6.setBounds(12, 216, 96, 24);
        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12, 240, 48, 24);
        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(120, 96, 156, 20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(120, 144, 156, 20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(120, 168, 156, 20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(120, 120, 156, 20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(120, 192, 156, 20);
        getContentPane().add(JTextField_NoOfEmp);
        JTextField_NoOfEmp.setBounds(120, 216, 156, 20);
        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(120, 240, 156, 20);
        JLabel8.setText("Acc Nr");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12, 72, 48, 24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(120, 72, 156, 20);
    }

    @Override
    protected void okActionListener() {
        bankFrame.setNoOfEmployees(JTextField_NoOfEmp.getText());
    }
}