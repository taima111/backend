package com.bankassurance.backend.models.responses;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RoleResponse {
    private Long id;
    private String nom;
    private boolean actif;
}
