package com.bankassurance.backend.controllers;

import com.bankassurance.backend.models.requests.RoleRequest;
import com.bankassurance.backend.models.responses.RoleResponse;
import com.bankassurance.backend.services.userservices.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public RoleResponse create(@RequestBody RoleRequest request) {
        return roleService.create(request);
    }

    @GetMapping
    public List<RoleResponse> getAll() {
        return roleService.getAll();
    }

    @PutMapping("/{id}")
    public RoleResponse update(@PathVariable Long id, @RequestBody RoleRequest request) {
        return roleService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

    @PutMapping("/{id}/disable")
    public void disable(@PathVariable Long id) {
        roleService.disable(id);
    }
}
