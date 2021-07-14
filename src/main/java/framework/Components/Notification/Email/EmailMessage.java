package framework.Components.Notification.Email;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
