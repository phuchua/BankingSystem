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
    public CardBtnActions(Controller controller, CardFrm cardFrm) {
        super(controller, cardFrm);
        this.cardFrm = cardFrm;
    }

    public final ActionListener generateBill = event -> {
        int selection = cardFrm.getDataTable().getSelectionModel().getMinSelectionIndex();
        String accNo = getSelectedAccountNo(selection);
        if (accNo != null) {
            openDialog(new JDialogGenBill(cardFrm, getController().getMonthlyBilling(accNo)));
        }
    };

    public final ActionListener addCreditCardAccount = event -> {
        openDialog(new JDialog_AddCCAccount(cardFrm));
        if (cardFrm.isNewAccount()) {
            Account account = getController().createAccount(cardFrm.getCcNumber(), cardFrm.getClientName(), cardFrm.getStateAddress(),
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
