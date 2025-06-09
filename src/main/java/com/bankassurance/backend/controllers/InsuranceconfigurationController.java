package com.bankassurance.backend.controllers;

import com.bankassurance.backend.services.userservices.InsuranceconfigurationService;

import com.bankassurance.backend.repository.configuration_entity.InsuranceConfiguration;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/insurance-config")
public class InsuranceconfigurationController {
    private static final Logger logger = LoggerFactory.getLogger(InsuranceconfigurationController.class);
    private final InsuranceconfigurationService service;

    @Autowired
    public InsuranceconfigurationController(InsuranceconfigurationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InsuranceConfiguration> createOrUpdate(@Valid @RequestBody InsuranceConfiguration config) {
        logger.debug("Received POST request to create/update InsuranceConfiguration: {}", config);
        InsuranceConfiguration savedConfig = service.createOrUpdate(config);
        logger.debug("Successfully saved InsuranceConfiguration with ID: {}", savedConfig.getId());
        return ResponseEntity.ok(savedConfig);
    }

    @GetMapping
    public ResponseEntity<List<InsuranceConfiguration>> getAll() {
        logger.debug("Received GET request to retrieve all InsuranceConfigurations");
        List<InsuranceConfiguration> configurations = service.getAll();
        logger.debug("Returning {} InsuranceConfigurations", configurations.size());
        return ResponseEntity.ok(configurations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceConfiguration> getById(@PathVariable Long id) {
        logger.debug("Received GET request for InsuranceConfiguration with ID: {}", id);
        Optional<InsuranceConfiguration> config = service.getById(id);
        if (config.isPresent()) {
            logger.debug("Found InsuranceConfiguration with ID: {}", id);
            return ResponseEntity.ok(config.get());
        } else {
            logger.debug("InsuranceConfiguration with ID: {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        logger.debug("Received DELETE request for InsuranceConfiguration with ID: {}", id);
        service.delete(id);
        logger.debug("Successfully deleted InsuranceConfiguration with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}