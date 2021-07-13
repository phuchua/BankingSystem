package framework.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
