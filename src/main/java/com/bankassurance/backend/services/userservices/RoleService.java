package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.models.requests.RoleRequest;
import com.bankassurance.backend.models.responses.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse create(RoleRequest request);
    List<RoleResponse> getAll();
    RoleResponse update(Long id, RoleRequest request);
    void delete(Long id);
    void disable(Long id);
}
