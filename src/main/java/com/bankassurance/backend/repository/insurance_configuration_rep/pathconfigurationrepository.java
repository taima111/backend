package com.bankassurance.backend.repository.insurance_configuration_rep;

import com.bankassurance.backend.repository.configuration_entity.PathConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface pathconfigurationrepository extends JpaRepository<PathConfiguration, Long> {

    @Query("SELECT p FROM PathConfiguration p WHERE p.thresholdsConfiguration.id = :thresholdsConfigurationId")
    Optional<PathConfiguration> findByThresholdsConfigurationId(@Param("thresholdsConfigurationId") Long thresholdsConfigurationId);

    @Query("SELECT p FROM PathConfiguration p WHERE (:thresholdsConfigurationId IS NULL OR p.thresholdsConfiguration.id = :thresholdsConfigurationId)")
    Page<PathConfiguration> findByThresholdsConfigurationId(
            @Param("thresholdsConfigurationId") Long thresholdsConfigurationId,
            Pageable pageable);
}