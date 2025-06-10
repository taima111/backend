package com.bankassurance.backend.services.imp;

import com.bankassurance.backend.models.utils.ThresholdConfigurationMapper;
import com.bankassurance.backend.repository.insurance_configuration_rep.ThresholdsConfigurationRepository;
import com.bankassurance.backend.services.userservices.ThresholdsConfigurationService;

import com.bankassurance.backend.dto.ThresholdsConfigurationDTO;
import com.bankassurance.backend.repository.configuration_entity.ThresholdsConfiguration;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ThresholdsConfigurationServiceImpl implements ThresholdsConfigurationService {
    private final ThresholdsConfigurationRepository repository;
    private final ThresholdConfigurationMapper mapper;

    public ThresholdsConfigurationServiceImpl(ThresholdsConfigurationRepository repository, ThresholdConfigurationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ThresholdsConfigurationDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ThresholdsConfigurationDTO create(ThresholdsConfigurationDTO config) {
        ThresholdsConfiguration entity = mapper.toEntity(config);
        ThresholdsConfiguration savedEntity = repository.save(entity);
        return mapper.toDTO(savedEntity);
    }

    @Override
    public ThresholdsConfigurationDTO update(Long id, ThresholdsConfigurationDTO updatedConfig) {
        Optional<ThresholdsConfiguration> existingConfig = repository.findById(id);
        if (existingConfig.isPresent()) {
            ThresholdsConfiguration entity = existingConfig.get();
            entity.setAssurance(updatedConfig.getAssurance());
            entity.setSeuilMontant(updatedConfig.getSeuilMontant());
            entity.setSeuilAge(updatedConfig.getSeuilAge());
            entity.setMaladie(updatedConfig.isMaladie());
            entity.setCompteJoint(updatedConfig.isCompteJoint());
            entity.setRembNonMensuel(updatedConfig.isRembNonMensuel());
            entity.setFranchise(updatedConfig.isFranchise());
            ThresholdsConfiguration updatedEntity = repository.save(entity);
            return mapper.toDTO(updatedEntity);
        }
        throw new RuntimeException("Configuration not found with id " + id);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}