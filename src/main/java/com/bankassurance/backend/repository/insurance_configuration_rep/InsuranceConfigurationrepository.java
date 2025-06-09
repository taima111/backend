package com.bankassurance.backend.repository.insurance_configuration_rep;
import com.bankassurance.backend.repository.configuration_entity.InsuranceConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceConfigurationrepository extends JpaRepository<InsuranceConfiguration, Long> {
}