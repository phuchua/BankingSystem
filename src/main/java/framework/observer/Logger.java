package framework.observer;

import framework.core.Account;

import java.util.Observable;
import java.util.Observer;

public class Logger implements Observer {
    Observable observable;
    private double balance;

    public Logger() { }

    public  Logger(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Account) {
            Account acc = (Account) o;
            this.balance = acc.getBalance();
            display();
        }
    }

    public void display() {
        System.out.println("Logger - Account balance is changed. Balance is " + this.balance);
    }
}
