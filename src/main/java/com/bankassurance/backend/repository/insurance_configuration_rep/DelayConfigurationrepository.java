package com.bankassurance.backend.repository.insurance_configuration_rep;

import com.bankassurance.backend.repository.configuration_entity.DelayConfiguration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DelayConfigurationrepository extends JpaRepository<DelayConfiguration, Long> {

    @Query("SELECT d FROM DelayConfiguration d WHERE (:thresholdsConfigurationId IS NULL OR d.thresholdsConfiguration.id = :thresholdsConfigurationId)")
    Page<DelayConfiguration> findByThresholdsConfigurationId(
            @Param("thresholdsConfigurationId") Long thresholdsConfigurationId,
            Pageable pageable);
}