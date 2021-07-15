package ui.bank;



import common.services.AccountService;

import java.awt.event.ActionListener;

public class BankBtnActions extends BtnActions {
    private BankFrm bankFrm;
    public BankBtnActions(AccountService accountService, BankFrm bankFrm) {
        super(accountService, bankFrm);
        this.bankFrm = bankFrm;
    }

    public ActionListener addPersonalAccount = event -> {
        openDialog(new JDialog_AddPAcc(bankFrm));
        if (bankFrm.isNewAccount()) {
//            accountService.createAccount(bankFrm.getAccountNo(), bankFrm.getClientName(), getAccStrategy(bankFrm.getAccountType()), getAccType(bankFrm.getAccountType()),
//                    bankFrm.getStreet(), bankFrm.getCity(), bankFrm.getStateAddress(), bankFrm.getZip(), "");

            bankFrm.updateTable("P");
        }
    };

    public ActionListener addBusinessAccount = event -> {
        openDialog(new JDialog_AddCompAcc(bankFrm));
        bankFrm.updateTable("C");
    };
}
