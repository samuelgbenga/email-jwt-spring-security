package ng.samuel.email_demo_1.auth.service;

public interface ConfirmationTokenService {

    String validateToken(String token);
}
