package ui.bank;


import banking.controllers.AccountController;
import common.models.Account;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BankBtnActions extends BtnActions {
    private BankFrm bankFrm;

    public BankBtnActions(AccountController accountController, BankFrm bankFrm) {
        super(accountController, bankFrm);
        this.bankFrm = bankFrm;
    }

    public final ActionListener addPersonalAccount = event -> {
        openDialog(new JDialog_AddPAcc(bankFrm));
        if (bankFrm.isNewAccount()) {
            Account account = getAccountController().createPersonalAccount(bankFrm.getAccountNo(),
                    bankFrm.getClientName(), bankFrm.getStateAddress(), bankFrm.getCity(), bankFrm.getStateAddress(),
                    bankFrm.getZip(), bankFrm.getCustomerEmail(), LocalDate.parse(bankFrm.getBirthDate()), getAccType(bankFrm.getAccountType()));

            bankFrm.updateTable(account);
        }
    };

    public ActionListener addBusinessAccount = event -> {
        openDialog(new JDialog_AddCompAcc(bankFrm));
        Account account = getAccountController().createCompanyAccount(bankFrm.getAccountNo(), bankFrm.getClientName(), bankFrm.getStateAddress(), bankFrm.getCity(), bankFrm.getStateAddress(),
                bankFrm.getZip(), bankFrm.getCustomerEmail(), Integer.parseInt(bankFrm.getNoOfEmployees()), getAccType(bankFrm.getAccountType()));
        bankFrm.updateTable(account);
    };
}
