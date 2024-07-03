package ng.samuel.email_demo_1.auth.service.impl;

import lombok.RequiredArgsConstructor;
import ng.samuel.email_demo_1.auth.entity.ConfirmationToken;
import ng.samuel.email_demo_1.auth.payload.request.EmailDetails;
import ng.samuel.email_demo_1.auth.payload.response.AuthResponse;
import ng.samuel.email_demo_1.auth.repository.ConfirmationTokenRepository;
import ng.samuel.email_demo_1.auth.service.AuthService;
import ng.samuel.email_demo_1.auth.service.ConfirmationTokenService;
import ng.samuel.email_demo_1.auth.service.EmailSenderService;
import ng.samuel.email_demo_1.model.User;
import ng.samuel.email_demo_1.payload.request.UserRequestDto;
import ng.samuel.email_demo_1.repository.UserRepository;
import ng.samuel.email_demo_1.utils.EmailBody;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final EmailSenderService emailSenderService;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(UserRequestDto userRequestDto) {


        if(userRepository.existsByEmail(userRequestDto.getEmail())){
            AuthResponse response = AuthResponse.builder()
                    .responseCode("000")
                    .responseMessage("Account Already Exist with that Email !")
                    .build();

            return response;
        }

        User newUser = User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .build();

        // save user to the db with enable set to false by default
        userRepository.save(newUser);

        // create a confirmation token and save in a db
        ConfirmationToken confirmationToken = new ConfirmationToken(newUser);
        confirmationTokenRepository.save(confirmationToken);

       String link = "http://localhost:8080/api/auth/confirm?token="+confirmationToken.getToken() ;

        EmailDetails emailDetail = EmailDetails.builder()
                .recipient(newUser.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody(EmailBody.buildEmail(newUser.getFirstName(), newUser.getLastName(), link))
                .attachment(null)
                .build();

        emailSenderService.sendMimeEmailAlert(emailDetail);

        return AuthResponse.builder()
                .responseCode("002")
                .responseMessage("Account Created to confirm use the following")
                .confirmationLink("http://localhost:8080/api/auth/confirm?token="+confirmationToken.getToken() )
                .build();
    }


}
