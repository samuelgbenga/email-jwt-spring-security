package ng.samuel.email_demo_1.payload.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
