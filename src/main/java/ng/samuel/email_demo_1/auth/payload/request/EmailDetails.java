package ng.samuel.email_demo_1.auth.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailDetails {

    private String recipient;

    private String messageBody;

    private String subject;

    private String attachment;
}

/*
how you send an attachment if needed

 */