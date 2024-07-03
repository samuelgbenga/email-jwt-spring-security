package ng.samuel.email_demo_1.service.impl;

import lombok.*;
import ng.samuel.email_demo_1.model.User;
import ng.samuel.email_demo_1.payload.request.LoginRequestDto;
import ng.samuel.email_demo_1.payload.response.LoginResponseDto;
import ng.samuel.email_demo_1.payload.response.UserInfo;
import ng.samuel.email_demo_1.payload.response.UserResponseDto;
import ng.samuel.email_demo_1.repository.UserRepository;
import ng.samuel.email_demo_1.service.JwtService;
import ng.samuel.email_demo_1.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
@Builder
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    @Override
    public UserResponseDto sayHello() {
        return UserResponseDto.builder()
                .responseCode("001")
                .responseMessage("this is just to say hi")
                .userInfo(UserInfo.builder()
                        .email("for now")
                        .build())
                .build();
    }

    @Override
    public LoginResponseDto userLogin(LoginRequestDto loginRequestDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDto.getEmail(), loginRequestDto.getPassword()
        ));


        User user = userRepository.findByEmail(loginRequestDto.getEmail()).orElseThrow(
                ()-> new RuntimeException("No such user with this email :"+ loginRequestDto.getEmail())
        );
        UserDetails userDetails = UserDetailsImpl.builder().user(user).build();


        if (!user.isEnabled()) {
            throw new RuntimeException("User account is not enabled. Please check your email to confirm your account.");
        }


        var jwtToken = jwtService.generateToken(userDetails);


        return LoginResponseDto.builder()
                .responseCode("007")
                .responseMessage("login Successful")
                .token(jwtToken)
                .build();
    }

}
