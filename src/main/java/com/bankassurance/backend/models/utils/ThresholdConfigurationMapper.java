package com.bankassurance.backend.models.utils;

import com.bankassurance.backend.dto.ThresholdsConfigurationDTO;
import com.bankassurance.backend.repository.configuration_entity.ThresholdsConfiguration;
import org.springframework.stereotype.Component;

@Component
public class ThresholdConfigurationMapper {

    // Convert Entity to DTO
    public ThresholdsConfigurationDTO toDTO(ThresholdsConfiguration entity) {
        if (entity == null) {
            return null;
        }
        return new ThresholdsConfigurationDTO(
                entity.getId(),
                entity.getAssurance(),
                entity.getSeuilMontant(),
                entity.getSeuilAge(),
                entity.isMaladie(),
                entity.isCompteJoint(),
                entity.isRembNonMensuel(),
                entity.isFranchise()
        );
    }

    // Convert DTO to Entity
    public ThresholdsConfiguration toEntity(ThresholdsConfigurationDTO dto) {
        if (dto == null) {
            return null;
        }
        ThresholdsConfiguration entity = new ThresholdsConfiguration();
        entity.setId(dto.getId());
        entity.setAssurance(dto.getAssurance());
        entity.setSeuilMontant(dto.getSeuilMontant());
        entity.setSeuilAge(dto.getSeuilAge());
        entity.setMaladie(dto.isMaladie());
        entity.setCompteJoint(dto.isCompteJoint());
        entity.setRembNonMensuel(dto.isRembNonMensuel());
        entity.setFranchise(dto.isFranchise());
        return entity;
    }
}