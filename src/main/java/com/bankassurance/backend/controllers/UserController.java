package com.bankassurance.backend.controllers;

import com.bankassurance.backend.models.enums.Role;
import com.bankassurance.backend.models.requests.UserRequest;
import com.bankassurance.backend.models.responses.UserResponse;
import com.bankassurance.backend.repository.entity.User;
import com.bankassurance.backend.services.userservices.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Integer id, @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/role")
    public ResponseEntity<Void> updateUserRole(@PathVariable Integer id, @RequestBody RoleUpdatePayload payload) {
        userService.updateUserRole(id, payload.getRole());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<Void> disableUser(@PathVariable Integer id) {
        userService.disableUser(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Void> enableUser(@PathVariable Integer id) {
        userService.enableUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(@AuthenticationPrincipal User currentUser) {
        return ResponseEntity.ok(userService.getProfile(currentUser));
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponse> updateProfile(@AuthenticationPrincipal User currentUser,
                                                      @RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.updateProfile(currentUser, request));
    }

    public static class RoleUpdatePayload {
        private Role role;
        public Role getRole() { return role; }
        public void setRole(Role role) { this.role = role; }
    }
}
