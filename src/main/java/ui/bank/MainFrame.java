package ui.bank;

import common.models.Account;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Setter
@Getter
public abstract class MainFrame extends JFrame {
    private String accountNo, clientName, street, city, zip, stateAddress, accountType, clientType,
            amountDeposit, customerEmail;
    private boolean newAccount;
    private DefaultTableModel model;
    private JTable dataTable;
    private JPanel panel;
    private JScrollPane JScrollPane1;
    private MainFrame frame;
    private Object[] rowData;

    public final void overview(String title, Collection<String> tableColumns, Collection<JButton> buttons) {
        prepareContentPane(title, tableColumns);
        prepareButtons(buttons);
        panelBounds();
        scrollPanelBounds();
        tableBounds();
        windowListeners();
    }

    private void prepareContentPane(String title, Collection<String> tableColumns) {
        panel = new JPanel();
        setTitle(title);
        setFrameSize();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        setVisible(false);
        panel.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, panel);

        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        dataTable = new JTable(model);

        for (String cols : tableColumns) {
            model.addColumn(cols);
        }
        rowData = new Object[tableColumns.size()];
        newAccount = false;
        panel.add(JScrollPane1);
        JScrollPane1.getViewport().add(dataTable);
    }

    public void prepareButtons(Collection<JButton> buttons) {
        for (JButton btn : buttons) {
            panel.add(btn);
        }
    }

    protected void windowListeners() {
    }

    protected void panelBounds() {
        panel.setBounds(0, 0, 575, 310);
    }

    protected void setFrameSize() {
        setSize(575, 310);
    }

    protected void tableBounds() {
        dataTable.setBounds(0, 0, 420, 0);
    }

    protected void scrollPanelBounds() {
        JScrollPane1.setBounds(12, 92, 444, 160);
    }

    protected void changeTableContent(String... cols) {
        System.arraycopy(cols, 0, rowData, 0, rowData.length);
        getModel().addRow(rowData);
        getDataTable().getSelectionModel().setAnchorSelectionIndex(-1);
    }

    private void clearTableData() {
        getModel().setRowCount(0);
    }

    public void updateAllTableRec(Collection<Account> accounts) {
        clearTableData();

        for (Account account:  accounts) {
            setNewAccount(true);
            updateTable(account);
        }
    }

    public abstract void updateTable(Account account);
}
