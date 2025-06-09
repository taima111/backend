package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.config.JwtService;
import com.bankassurance.backend.models.requests.AuthenticationRequest;
import com.bankassurance.backend.models.requests.RegisterRequest;
import com.bankassurance.backend.models.responses.AuthenticationResponse;
import com.bankassurance.backend.repository.entity.Token;
import com.bankassurance.backend.repository.entity.User;
import com.bankassurance.backend.repository.rep.TokenRepository;
import com.bankassurance.backend.repository.rep.UserRepository;
import com.bankassurance.backend.services.userservices.AuthenticationService;
import com.bankassurance.backend.models.enums.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        System.out.println("Début de l'inscription pour : " + request.getEmail());
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .actif(true)
                .build();

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser, jwtToken);
        System.out.println("Utilisateur inscrit avec succès : " + savedUser.getEmail());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .email(savedUser.getEmail())
                .role(savedUser.getRole().name())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            System.out.println("Début de l'authentification pour : " + request.getEmail());
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );

            var user = repository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            System.out.println("Utilisateur authentifié : " + user.getEmail());

            var jwtToken = jwtService.generateToken(user);
            System.out.println("Token généré : " + jwtToken);

            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken);
            System.out.println("Nouveau token enregistré pour : " + user.getEmail());

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .email(user.getEmail())
                    .role(user.getRole().name())
                    .build();
        } catch (Exception e) {
            System.err.println("Erreur lors de l'authentification pour " + request.getEmail() + " : " + e.getMessage());
            throw e;
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        System.out.println("Enregistrement d'un nouveau token pour : " + user.getEmail());
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
        System.out.println("Token enregistré avec succès pour : " + user.getEmail());
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty()) {
            System.out.println("Aucun token valide trouvé pour l'utilisateur : " + user.getEmail());
            return;
        }

        System.out.println("Tokens valides trouvés pour l'utilisateur " + user.getEmail() + " : " + validUserTokens.size());

        int maxRetries = 3;
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                validUserTokens.forEach(token -> {
                    token.setExpired(true);
                    token.setRevoked(true);
                });
                tokenRepository.saveAll(validUserTokens);
                System.out.println("Tokens révoqués avec succès pour l'utilisateur : " + user.getEmail());
                break; // Succès, sort de la boucle
            } catch (PessimisticLockingFailureException e) {
                retryCount++;
                System.out.println("Échec de la révocation des tokens (tentative " + retryCount + "/" + maxRetries + ") : " + e.getMessage());
                if (retryCount == maxRetries) {
                    System.err.println("Échec définitif de la révocation des tokens pour " + user.getEmail());
                    throw e; // Échec après toutes les tentatives
                }
                try {
                    Thread.sleep(1000); // Attendre 1 seconde avant de réessayer
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}