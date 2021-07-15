package ui.ccard;
/*
		A basic implementation of the JDialog class.
*/

import common.models.AccountEntry;
import ui.bank.AccountDialog;

import javax.swing.*;
import java.util.Collection;

public class JDialogGenBill extends AccountDialog {
	JScrollPane JScrollPane1 = new javax.swing.JScrollPane();
    String billString;
	Collection<AccountEntry> accountEntries;
	private JTextField JTextField1 = new JTextField();
	private JButton JButton_OK = new JButton();

	public JDialogGenBill(CardFrm parent, Collection<AccountEntry> accountEntries) {
		super(parent, "Report");
		setSize(758, 240);
		this.accountEntries = accountEntries;
		setUniqueFields();
	}

	@Override
	protected void setUniqueFields() {
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,758,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		generateReport();
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);
		JButton_OK.addActionListener(cancelAction);
	}

	private void generateReport() {
		billString = "";
		accountEntries.forEach(a -> billString += a.toString());
		JTextField1.setText(billString);
	}

	@Override
	protected void okActionListener() {
	}
}
