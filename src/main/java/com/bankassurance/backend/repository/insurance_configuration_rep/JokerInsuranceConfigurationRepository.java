package com.bankassurance.backend.repository.insurance_configuration_rep;

import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokerInsuranceConfigurationRepository extends JpaRepository<JokerInsuranceConfiguration, Long> {
}