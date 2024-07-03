package ng.samuel.email_demo_1.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    // extract username
    String extractUsername(String token);

    // extract single claim
    <T> T extractClaim(String token, Function<Claims, T> claimResolver);

    // generate token;
    String generateToken(UserDetails userDetails);

    // check if token is valid or not
    boolean isTokenValid (String token, UserDetails userDetails);

}
