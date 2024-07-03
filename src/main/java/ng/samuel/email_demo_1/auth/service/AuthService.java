package ng.samuel.email_demo_1.auth.service;

import ng.samuel.email_demo_1.auth.payload.response.AuthResponse;
import ng.samuel.email_demo_1.payload.request.UserRequestDto;

public interface AuthService {

    AuthResponse register(UserRequestDto userRequestDto);

}
