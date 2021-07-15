package framework.Components.Notification.Email;

import framework.Components.Notification.Notification;

public class EmailNotification implements Notification {
    private EmailMessage message;
    public EmailNotification(EmailMessage message) {
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Send Email to "+message.getTo() +" Message: "+message.getBody());
    }
}
