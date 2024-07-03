package ng.samuel.email_demo_1.service;

import ng.samuel.email_demo_1.payload.request.LoginRequestDto;
import ng.samuel.email_demo_1.payload.request.UserRequestDto;
import ng.samuel.email_demo_1.payload.response.LoginResponseDto;
import ng.samuel.email_demo_1.payload.response.UserResponseDto;

public interface UserService {
    UserResponseDto sayHello();

    LoginResponseDto userLogin(LoginRequestDto loginRequestDto);
}
