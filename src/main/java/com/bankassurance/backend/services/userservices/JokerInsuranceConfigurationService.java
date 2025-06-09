package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;

import java.util.List;
import java.util.Optional;

public interface JokerInsuranceConfigurationService {
    JokerInsuranceConfiguration createOrUpdate(JokerInsuranceConfiguration config);
    void delete(Long id);
    List<JokerInsuranceConfiguration> getAll();
    Optional<JokerInsuranceConfiguration> getById(Long id);
}