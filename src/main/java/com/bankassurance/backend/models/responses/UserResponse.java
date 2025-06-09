package com.bankassurance.backend.models.responses;

import com.bankassurance.backend.models.enums.Role;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
}