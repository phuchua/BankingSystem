package ui.bank;

import common.services.AccountService;
import ui.ccard.CardFrm;
import ui.ccard.JDialogGenBill;
import ui.ccard.JDialog_AddCCAccount;

import java.awt.event.ActionListener;

public class CardBtnActions extends BtnActions {
    private CardFrm cardFrm;
    public CardBtnActions(AccountService accountService, CardFrm cardFrm) {
        super(accountService, cardFrm);
        this.cardFrm = cardFrm;
    }

    public final ActionListener generateBill = event -> openDialog(new JDialogGenBill(cardFrm));

    public final ActionListener addCreditCardAccount = event -> {
        openDialog(new JDialog_AddCCAccount(cardFrm));
        if (cardFrm.isNewAccount()) {
//            accountService.createAccount(cardFrm.getAccountNo(), cardFrm.getClientName(), getAccStrategy(cardFrm.getAccountType()), getAccType(cardFrm.getAccountType()),
//                    cardFrm.getStreet(), cardFrm.getCity(), cardFrm.getStateAddress(), cardFrm.getZip(), "");

            cardFrm.updateTable("P");
        }
    };
}
