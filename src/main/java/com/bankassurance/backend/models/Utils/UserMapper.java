package com.bankassurance.backend.models.Utils;

import com.bankassurance.backend.models.requests.UserRequest;
import com.bankassurance.backend.models.responses.UserResponse;
import com.bankassurance.backend.repository.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Convertit une UserRequest en User avec encodage du mot de passe.
     * Utilisé lors de la création.
     */
    public User toEntity(UserRequest request) {
        String encodedPassword = request.getPassword() != null && !request.getPassword().isBlank()
                ? passwordEncoder.encode(request.getPassword())
                : null;

        return User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(encodedPassword) // ⚠️ Attention : peut être null si vide
                .role(request.getRole())
                .actif(true)
                .build();
    }

    /**
     * Convertit un User en UserResponse pour le frontend.
     */
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
