package ng.samuel.email_demo_1.payload.response;


import lombok.*;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto {

    private String responseCode;

    private String responseMessage;

    private UserInfo userInfo;


}
