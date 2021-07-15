package ui.bank;

import banking.controllers.AccountController;
import banking.controllers.IAccountController;
import common.models.Account;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BankBtnActions extends BtnActions {
    private BankFrm bankFrm;

    public BankBtnActions(IAccountController accountController, BankFrm bankFrm) {
        super(accountController, bankFrm);
        this.bankFrm = bankFrm;
    }

    public final ActionListener addPersonalAccount = event -> {
        openDialog(new JDialog_AddPAcc(bankFrm));
        if (bankFrm.isNewAccount()) {
            Account account = getController().createPersonalAccount(bankFrm.getAccountNo(),
                    bankFrm.getClientName(), bankFrm.getStateAddress(), bankFrm.getCity(), bankFrm.getStateAddress(),
                    bankFrm.getZip(), bankFrm.getCustomerEmail(), LocalDate.parse(bankFrm.getBirthDate()), getAccType(bankFrm.getAccountType()));

            bankFrm.updateTable(account);
        }
    };

    public ActionListener addBusinessAccount = event -> {
        openDialog(new JDialog_AddCompAcc(bankFrm));
        Account account = getController().createCompanyAccount(bankFrm.getAccountNo(), bankFrm.getClientName(), bankFrm.getStateAddress(), bankFrm.getCity(), bankFrm.getStateAddress(),
                bankFrm.getZip(), bankFrm.getCustomerEmail(), Integer.parseInt(bankFrm.getNoOfEmployees()), getAccType(bankFrm.getAccountType()));
        bankFrm.updateTable(account);
    };

    @Override
    protected int balanceColumn() {
        return 5;
    }

    @Override
    protected int getAccountNoColumn() {
        return 0;
    }
}
