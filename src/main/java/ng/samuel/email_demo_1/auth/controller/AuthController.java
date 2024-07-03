package ng.samuel.email_demo_1.auth.controller;


import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ng.samuel.email_demo_1.auth.payload.response.AuthResponse;
import ng.samuel.email_demo_1.auth.service.AuthService;
import ng.samuel.email_demo_1.auth.service.ConfirmationTokenService;
import ng.samuel.email_demo_1.payload.request.LoginRequestDto;
import ng.samuel.email_demo_1.payload.request.UserRequestDto;
import ng.samuel.email_demo_1.payload.response.LoginResponseDto;
import ng.samuel.email_demo_1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final AuthService authService;

    private final ConfirmationTokenService confirmationTokenService;


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDto userRequestDto) {

        try{
            AuthResponse registerUser  = authService.register(userRequestDto);
            if(!registerUser.getResponseCode().equals("000")){
                return ResponseEntity.ok(registerUser);
            }else {
                return ResponseEntity.badRequest().body("Invalid Email!!!");
            }
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }

    }

    // confirm the email

    @GetMapping("/confirm")
    public ResponseEntity<?> confirmEmail(@RequestParam("token") String token){

        String result = confirmationTokenService.validateToken(token);
        if ("Email confirmed successfully".equals(result)) {
            return ResponseEntity.ok(Collections.singletonMap("message", result));
        } else {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", result));
        }

    }

    // user login
    // login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto response = userService.userLogin(loginRequestDto);
        return ResponseEntity.ok(response);
    }
}
