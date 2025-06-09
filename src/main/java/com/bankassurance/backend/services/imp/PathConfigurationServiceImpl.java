package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.repository.configuration_entity.PathConfiguration;
import com.bankassurance.backend.repository.insurance_configuration_rep.pathconfigurationrepository;
import com.bankassurance.backend.services.userservices.PathConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PathConfigurationServiceImpl implements PathConfigurationService {

    private static final Logger logger = LoggerFactory.getLogger(PathConfigurationServiceImpl.class);

    private final pathconfigurationrepository repository;

    public PathConfigurationServiceImpl(pathconfigurationrepository repository) {
        this.repository = repository;
    }

    @Override
    public PathConfiguration save(PathConfiguration config) {
        logger.info("Saving path configuration: {}", config);
        return repository.save(config);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting path configuration with id={}", id);
        if (!repository.existsById(id)) {
            throw new RuntimeException("Path configuration not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Page<PathConfiguration> findAllWithFilters(Long thresholdsConfigurationId, Pageable pageable) {
        logger.info("Fetching path configurations with thresholdsConfigurationId={}", thresholdsConfigurationId);
        if (thresholdsConfigurationId == null) {
            return repository.findAll(pageable);
        }
        return repository.findByThresholdsConfigurationId(thresholdsConfigurationId, pageable);
    }

    @Override
    public Optional<PathConfiguration> findByThresholdsConfigurationId(Long thresholdsConfigurationId) {
        logger.info("Fetching path configuration with thresholdsConfigurationId={}", thresholdsConfigurationId);
        return repository.findByThresholdsConfigurationId(thresholdsConfigurationId);
    }
}