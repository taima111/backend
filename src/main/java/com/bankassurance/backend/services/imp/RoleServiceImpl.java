package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.repository.entity.Role;
import com.bankassurance.backend.models.requests.RoleRequest;
import com.bankassurance.backend.models.responses.RoleResponse;
import com.bankassurance.backend.repository.rep.RoleRepository;
import com.bankassurance.backend.services.userservices.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponse create(RoleRequest request) {
        Role role = new Role();
        role.setNom(request.getNom());
        role.setActif(true);
        role = roleRepository.save(role);
        return toResponse(role);
    }

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(this::toResponse).toList();
    }

    @Override
    public RoleResponse update(Long id, RoleRequest request) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        role.setNom(request.getNom());
        return toResponse(roleRepository.save(role));
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void disable(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rôle non trouvé"));
        role.setActif(false);
        roleRepository.save(role);
    }

    private RoleResponse toResponse(Role role) {
        return new RoleResponse(role.getId(), role.getNom(), role.isActif());
    }
}
