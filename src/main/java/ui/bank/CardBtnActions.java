package ui.bank;

import banking.controllers.AccountController;
import common.models.Account;
import ui.ccard.CardFrm;
import ui.ccard.JDialogGenBill;
import ui.ccard.JDialog_AddCCAccount;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CardBtnActions extends BtnActions {
    private CardFrm cardFrm;

    public CardBtnActions(AccountController accountController, CardFrm cardFrm) {
        super(accountController, cardFrm);
        this.cardFrm = cardFrm;
    }

    public final ActionListener generateBill = event -> openDialog(new JDialogGenBill(cardFrm));

    public final ActionListener addCreditCardAccount = event -> {
        openDialog(new JDialog_AddCCAccount(cardFrm));
        if (cardFrm.isNewAccount()) {
//            create credit card
            Account account = getAccountController().createPersonalAccount(cardFrm.getAccountNo(), cardFrm.getClientName(), cardFrm.getStateAddress(), cardFrm.getCity(), cardFrm.getStateAddress(),
                    cardFrm.getZip(), cardFrm.getCustomerEmail(), LocalDate.parse(cardFrm.getCcNumber()), getAccType(cardFrm.getAccountType()));

            cardFrm.updateTable(account);
        }
    };
}
