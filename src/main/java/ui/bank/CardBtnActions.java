package ui.bank;

import ccard.enums.CreditCardType;
import common.models.Account;
import framework.Controller;
import ui.ccard.CardFrm;
import ui.ccard.JDialogGenBill;
import ui.ccard.JDialog_AddCCAccount;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CardBtnActions extends BtnActions {
    private CardFrm cardFrm;
    private Controller cac;

    public CardBtnActions(Controller controller, CardFrm cardFrm) {
        super(controller, cardFrm);
        this.cardFrm = cardFrm;
        cac = controller;
    }

    public final ActionListener generateBill = event -> openDialog(new JDialogGenBill(cardFrm));

    public final ActionListener addCreditCardAccount = event -> {
        openDialog(new JDialog_AddCCAccount(cardFrm));
        if (cardFrm.isNewAccount()) {
            Account account = cac.createAccount(cardFrm.getCcNumber(), cardFrm.getClientName(), cardFrm.getStateAddress(),
                    cardFrm.getCity(), cardFrm.getStateAddress(), cardFrm.getZip(), cardFrm.getCustomerEmail(),
                    LocalDate.parse(cardFrm.getExpDate()), getAccType(cardFrm.getAccountType()), getCCType(cardFrm.getAccountType()));

            cardFrm.updateTable(account);
        }
    };

    private CreditCardType getCCType(String accountType) {
        CreditCardType type = null;
        switch (accountType) {
            case "Gold":
                type = CreditCardType.GOLD;
                break;
            case "Silver":
                type = CreditCardType.SILVER;
                break;
            case "Bronze":
                type = CreditCardType.BRONZE;
                break;
            default:
                break;
        }
        return type;
    }

    @Override
    protected int balanceColumn() {
        return 4;
    }

    @Override
    protected int getAccountNoColumn() {
        return 1;
    }
}
