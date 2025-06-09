package com.bankassurance.backend.repository.rep;

import com.bankassurance.backend.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);  // pour Spring Security

    List<User> findByRole(com.bankassurance.backend.models.enums.Role role);
}
