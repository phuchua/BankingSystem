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
            this.balance = acc.getBalance();
            display();
        }
    }

    public void display(){
        System.out.println("EmailSender - Account is created. Balance is " + this.balance);
    }
}
