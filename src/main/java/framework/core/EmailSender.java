package framework.core;

import java.util.Observable;
import java.util.Observer;

public class EmailSender implements Observer {
    Observable observable;
    private double balance;

    public EmailSender() {
    }

    public EmailSender(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Account){
            Account acc = (Account)o;
            AccountEntry entry = (AccountEntry) arg;

            if (acc.getAccountClass().equals(AccountClass.COMPANY)
                    ||(acc.getAccountClass().equals(AccountClass.PERSONAL) && (entry.getAmount()>500 || entry.getAmount()<0))
                    ||(acc.getAccountClass().equals(AccountClass.PERSONAL) && acc.getBalance()+entry.getAmount()<0)
                    ||(acc.getAccountClass().equals(AccountClass.CREDITCARD) && (entry.getAmount()>500 || entry.getAmount()<0)
                    ||(acc.getAccountClass().equals(AccountClass.CREDITCARD) && acc.getBalance()+entry.getAmount()<0)))
            {
                StringBuilder sb = new StringBuilder();
                sb.append("------------------------------------------------------\n");
                sb.append("Sent to: " + acc.customer.getEmailAddress());
                sb.append("\n");
                sb.append("Account: " + acc.getCustomer().getName());
                sb.append("\n");

                if (entry.getAmount() > 0)
                    sb.append("There is a deposit " + entry.getAmount() + " to account " + entry.getFromAccountNumber() + "(" + entry.getDescription() + ")");

                if (entry.getAmount() < 0)
                    sb.append("There is a withdraw " + entry.getAmount() + " from account " + entry.getFromAccountNumber() + " (" + entry.getDescription() + ")");
                sb.append("\n");
                sb.append("Account balance of  is " + acc.getBalance());
                sb.append("\n------------------------------------------------------");

                System.out.println("Email sent");
                System.out.println(sb.toString());
            }
        }
    }
}
