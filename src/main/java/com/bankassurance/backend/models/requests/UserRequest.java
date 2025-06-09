package com.bankassurance.backend.models.requests;

import com.bankassurance.backend.models.enums.Role;
import lombok.Data;

@Data
public class UserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
}
