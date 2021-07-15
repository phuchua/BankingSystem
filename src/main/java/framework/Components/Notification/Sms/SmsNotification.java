package framework.Components.Notification.Sms;

import framework.Components.Notification.Notification;

public class SmsNotification implements Notification {
    private SmsMessage message;
    public SmsNotification(SmsMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Send Sending to "+message.getTo() +" Message: "+message.getBody());
    }
}
