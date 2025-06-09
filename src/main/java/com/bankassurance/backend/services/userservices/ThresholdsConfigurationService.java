package com.bankassurance.backend.services.userservices;


import com.bankassurance.backend.dto.ThresholdsConfigurationDTO;

import java.util.List;

public interface ThresholdsConfigurationService {
    List<ThresholdsConfigurationDTO> getAll();
    ThresholdsConfigurationDTO create(ThresholdsConfigurationDTO config);
    ThresholdsConfigurationDTO update(Long id, ThresholdsConfigurationDTO updatedConfig);
    void delete(Long id);
}