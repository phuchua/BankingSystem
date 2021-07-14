package framework.oldfiles.observer;

import framework.oldfiles.core.Account;

import java.util.Observable;
import java.util.Observer;

public class SMSSender implements Observer {
    Observable observable;
    private double balance;

    public SMSSender() { }

    public SMSSender(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Account) {
            Account acc = (Account)o;
            this.balance = acc.getBalance();
            display();
        }
    }

    public void display(){
        System.out.println("SMSSender - Account balance is changed. Balance is " + this.balance);
    }
}
