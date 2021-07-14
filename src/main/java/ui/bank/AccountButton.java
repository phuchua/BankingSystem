package ui.bank;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AccountButton extends JButton {
    public AccountButton(String btnName, ActionListener actionListener, int x, int y, int width, int height) {
        super(btnName);
        setText(btnName);
        addActionListener(actionListener);
        setBounds(x, y, width, height);
    }
}
