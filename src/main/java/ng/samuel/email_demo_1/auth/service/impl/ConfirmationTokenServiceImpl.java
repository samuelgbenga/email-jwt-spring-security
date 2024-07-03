package ng.samuel.email_demo_1.auth.service.impl;


import lombok.RequiredArgsConstructor;
import ng.samuel.email_demo_1.auth.entity.ConfirmationToken;
import ng.samuel.email_demo_1.auth.repository.ConfirmationTokenRepository;
import ng.samuel.email_demo_1.auth.service.ConfirmationTokenService;
import ng.samuel.email_demo_1.model.User;
import ng.samuel.email_demo_1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final UserRepository userRepository;


    @Override
    public String validateToken(String token) {
        Optional<ConfirmationToken> confirmationTokenOptional = confirmationTokenRepository.findByToken(token);
        if (confirmationTokenOptional.isEmpty()) {
            return "Invalid token";
        }

        ConfirmationToken confirmationToken = confirmationTokenOptional.get();

        if (confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            User user = confirmationToken.getUser();
            userRepository.delete(user);
            confirmationTokenRepository.delete(confirmationToken);
            return "Token has expired: You have to register again.";
        }

        User user = confirmationToken.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        confirmationTokenRepository.delete(confirmationToken); //delete the token after successful verification

        return "Email confirmed successfully";
    }
}
