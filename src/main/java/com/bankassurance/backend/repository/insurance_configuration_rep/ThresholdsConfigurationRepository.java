package com.bankassurance.backend.repository.insurance_configuration_rep;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankassurance.backend.repository.configuration_entity.ThresholdsConfiguration;

public interface ThresholdsConfigurationRepository extends JpaRepository<ThresholdsConfiguration, Long> {
}