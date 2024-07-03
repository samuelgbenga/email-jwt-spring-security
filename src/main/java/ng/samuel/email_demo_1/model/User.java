package ng.samuel.email_demo_1.model;


import jakarta.persistence.*;
import lombok.*;
import ng.samuel.email_demo_1.auth.entity.ConfirmationToken;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean enabled = false;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ConfirmationToken> confirmationTokens;
}
