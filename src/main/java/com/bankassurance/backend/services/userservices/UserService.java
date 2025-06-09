package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.models.enums.Role;
import com.bankassurance.backend.models.requests.UserRequest;
import com.bankassurance.backend.models.responses.UserResponse;
import com.bankassurance.backend.repository.entity.User;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(Integer id, UserRequest request);
    void deleteUser(Integer id);
    void updateUserRole(Integer id, Role newRole);
    void disableUser(Integer id);
    void enableUser(Integer id);
    UserResponse getProfile(User currentUser);
    UserResponse updateProfile(User currentUser, UserRequest request);
}
