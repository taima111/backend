package com.bankassurance.backend.controllers;

import com.bankassurance.backend.repository.configuration_entity.PathConfiguration;
import com.bankassurance.backend.services.userservices.PathConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/path-configurations")
public class PathConfigurationController {

    private static final Logger logger = LoggerFactory.getLogger(PathConfigurationController.class);

    private final PathConfigurationService service;

    public PathConfigurationController(PathConfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PathConfiguration> create(@Valid @RequestBody PathConfiguration config) {
        logger.info("Creating path configuration: {}", config);
        return ResponseEntity.ok(service.save(config));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody PathConfiguration config) {
        logger.info("Updating path configuration with id={}: {}", id, config);
        Optional<PathConfiguration> existing = service.findByThresholdsConfigurationId(config.getThresholdsConfiguration().getId());
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        config.setId(id);
        return ResponseEntity.ok(service.save(config));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.info("Deleting path configuration with id={}", id);
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<PathConfiguration>> getAll(
            @RequestParam(required = false) Long thresholdsConfigurationId,
            Pageable pageable) {
        logger.info("Fetching path configurations with thresholdsConfigurationId={}", thresholdsConfigurationId);
        return ResponseEntity.ok(service.findAllWithFilters(thresholdsConfigurationId, pageable));
    }

    @GetMapping("/thresholds/{thresholdsConfigurationId}")
    public ResponseEntity<PathConfiguration> getByThresholdsConfigurationId(@PathVariable Long thresholdsConfigurationId) {
        logger.info("Fetching path configuration with thresholdsConfigurationId={}", thresholdsConfigurationId);
        return service.findByThresholdsConfigurationId(thresholdsConfigurationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}