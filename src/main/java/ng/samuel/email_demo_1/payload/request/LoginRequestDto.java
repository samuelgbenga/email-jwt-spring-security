package ng.samuel.email_demo_1.payload.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDto {
    private String email;

    private String password;
}
