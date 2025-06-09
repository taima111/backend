package com.bankassurance.backend.services.userservices;
import com.bankassurance.backend.repository.configuration_entity.InsuranceConfiguration;

import java.util.List;
import java.util.Optional;

public interface InsuranceconfigurationService {
    InsuranceConfiguration createOrUpdate(InsuranceConfiguration config);
    void delete(Long id);
    List<InsuranceConfiguration> getAll();
    Optional<InsuranceConfiguration> getById(Long id);
}