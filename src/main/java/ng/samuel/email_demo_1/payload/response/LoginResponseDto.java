package ng.samuel.email_demo_1.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {

    private String responseCode;

    private String responseMessage;

    private String token;
}
