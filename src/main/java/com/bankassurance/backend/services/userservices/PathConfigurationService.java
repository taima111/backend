package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.repository.configuration_entity.PathConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PathConfigurationService {

    PathConfiguration save(PathConfiguration config);

    void delete(Long id);

    Page<PathConfiguration> findAllWithFilters(Long thresholdsConfigurationId, Pageable pageable);

    Optional<PathConfiguration> findByThresholdsConfigurationId(Long thresholdsConfigurationId);
}