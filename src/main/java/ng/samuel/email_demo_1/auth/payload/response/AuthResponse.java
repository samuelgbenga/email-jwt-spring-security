package ng.samuel.email_demo_1.auth.payload.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ng.samuel.email_demo_1.payload.response.UserInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {

    private String responseCode;

    private String responseMessage;

    private String confirmationLink;

    private UserInfo userInfo;
}
