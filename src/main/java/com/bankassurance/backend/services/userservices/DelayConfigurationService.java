package com.bankassurance.backend.services.userservices;

import com.bankassurance.backend.dto.DelayConfigurationDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DelayConfigurationService {

    Page<DelayConfigurationDTO> getAllDelayConfigurations(Long thresholdsConfigurationId, Pageable pageable);

    DelayConfigurationDTO getDelayConfigurationById(Long id);

    DelayConfigurationDTO saveDelayConfiguration(DelayConfigurationDTO dto);

    void deleteDelayConfiguration(Long id);
}