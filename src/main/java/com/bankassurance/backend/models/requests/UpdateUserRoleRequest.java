package com.bankassurance.backend.models.requests;

import com.bankassurance.backend.models.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRoleRequest {
    private Role role;
}
