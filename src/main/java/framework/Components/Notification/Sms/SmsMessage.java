package framework.Components.Notification.Sms;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmsMessage {
    private String to;
    private String body;
}
