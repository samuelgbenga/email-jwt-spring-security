package ng.samuel.email_demo_1.payload.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {

    private String firstName;

    private String lastName;

    private String email;

}
