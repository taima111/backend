package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.dto.DelayConfigurationDTO;
import com.bankassurance.backend.repository.configuration_entity.DelayConfiguration;
import com.bankassurance.backend.repository.configuration_entity.ThresholdsConfiguration;
import com.bankassurance.backend.repository.insurance_configuration_rep.DelayConfigurationrepository;
import com.bankassurance.backend.repository.insurance_configuration_rep.ThresholdsConfigurationRepository;
import com.bankassurance.backend.services.userservices.DelayConfigurationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DelayConfigurationServiceImpl implements DelayConfigurationService {

    private static final Logger logger = LoggerFactory.getLogger(DelayConfigurationServiceImpl.class);

    private final DelayConfigurationrepository delayRepository;
    private final ThresholdsConfigurationRepository thresholdsRepository;

    public DelayConfigurationServiceImpl(
            DelayConfigurationrepository delayRepository,
            com.bankassurance.backend.repository.insurance_configuration_rep.ThresholdsConfigurationRepository thresholdsRepository) {
        this.delayRepository = delayRepository;
        this.thresholdsRepository = thresholdsRepository;
    }

    @Override
    public Page<DelayConfigurationDTO> getAllDelayConfigurations(Long thresholdsConfigurationId, Pageable pageable) {
        logger.info("Fetching delay configurations with thresholdsConfigurationId={}", thresholdsConfigurationId);
        Page<DelayConfiguration> configurations = delayRepository.findByThresholdsConfigurationId(thresholdsConfigurationId, pageable);
        return configurations.map(this::convertToDto);
    }

    @Override
    public DelayConfigurationDTO getDelayConfigurationById(Long id) {
        logger.info("Fetching delay configuration with id={}", id);
        DelayConfiguration configuration = delayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delay configuration not found with id: " + id));
        return convertToDto(configuration);
    }

    @Override
    public DelayConfigurationDTO saveDelayConfiguration(DelayConfigurationDTO dto) {
        logger.info("Saving delay configuration: {}", dto);
        if (dto.getThresholdsConfigurationId() == null) {
            throw new IllegalArgumentException("ThresholdsConfigurationId cannot be null");
        }
        ThresholdsConfiguration thresholdsConfiguration = thresholdsRepository.findById(dto.getThresholdsConfigurationId())
                .orElseThrow(() -> new RuntimeException("ThresholdsConfiguration not found with id: " + dto.getThresholdsConfigurationId()));
        DelayConfiguration configuration = convertToEntity(dto);
        configuration.setThresholdsConfiguration(thresholdsConfiguration);
        configuration = delayRepository.save(configuration);
        return convertToDto(configuration);
    }

    @Override
    public void deleteDelayConfiguration(Long id) {
        logger.info("Deleting delay configuration with id={}", id);
        if (!delayRepository.existsById(id)) {
            throw new RuntimeException("Delay configuration not found with id: " + id);
        }
        delayRepository.deleteById(id);
    }

    private DelayConfigurationDTO convertToDto(DelayConfiguration entity) {
        DelayConfigurationDTO dto = new DelayConfigurationDTO();
        dto.setId(entity.getId());
        dto.setThresholdsConfigurationId(entity.getThresholdsConfiguration() != null ? entity.getThresholdsConfiguration().getId() : null);
        dto.setDelaiAnnulation(entity.getDelaiAnnulation());
        dto.setDelaiResiliation(entity.getDelaiResiliation());
        return dto;
    }

    private DelayConfiguration convertToEntity(DelayConfigurationDTO dto) {
        DelayConfiguration entity = new DelayConfiguration();
        entity.setId(dto.getId());
        entity.setDelaiAnnulation(dto.getDelaiAnnulation());
        entity.setDelaiResiliation(dto.getDelaiResiliation());
        return entity;
    }
}