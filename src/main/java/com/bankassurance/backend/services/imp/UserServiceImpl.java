package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.models.Utils.UserMapper;
import com.bankassurance.backend.models.enums.Role;
import com.bankassurance.backend.models.requests.UserRequest;
import com.bankassurance.backend.models.responses.UserResponse;
import com.bankassurance.backend.repository.entity.User;
import com.bankassurance.backend.repository.rep.UserRepository;
import com.bankassurance.backend.services.userservices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // ✅ encodage du mot de passe
        user.setActif(true);
        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest request) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));

        existingUser.setFirstname(request.getFirstname());
        existingUser.setLastname(request.getLastname());
        existingUser.setEmail(request.getEmail());
        existingUser.setRole(request.getRole());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(request.getPassword())); // ✅ encodage
        }

        return userMapper.toResponse(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void updateUserRole(Integer id, Role role) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));

        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void disableUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));

        user.setActif(false);
        userRepository.save(user);
    }

    @Override
    public void enableUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Utilisateur non trouvé"));

        user.setActif(true);
        userRepository.save(user);
    }

    @Override
    public UserResponse getProfile(User user) {
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateProfile(User currentUser, UserRequest request) {
        currentUser.setFirstname(request.getFirstname());
        currentUser.setLastname(request.getLastname());
        currentUser.setEmail(request.getEmail());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            currentUser.setPassword(passwordEncoder.encode(request.getPassword())); // ✅ encodage
        }

        return userMapper.toResponse(userRepository.save(currentUser));
    }
}
