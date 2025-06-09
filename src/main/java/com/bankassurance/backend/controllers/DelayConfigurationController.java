package com.bankassurance.backend.controllers;

import com.bankassurance.backend.dto.DelayConfigurationDTO;
import com.bankassurance.backend.services.userservices.DelayConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/delay")
public class DelayConfigurationController {

    private static final Logger logger = LoggerFactory.getLogger(DelayConfigurationController.class);

    private final DelayConfigurationService service;

    public DelayConfigurationController(DelayConfigurationService service) {
        this.service = service;
    }

    @GetMapping("/configurations")
    @PreAuthorize("isAuthenticated()")
    public Page<DelayConfigurationDTO> getAllDelayConfigurations(
            @RequestParam(required = false) Long thresholdsConfigurationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        logger.info("Received request for getAllDelayConfigurations with thresholdsConfigurationId={}, page={}, size={}", thresholdsConfigurationId, page, size);
        Pageable pageable = PageRequest.of(page, size);
        return service.getAllDelayConfigurations(thresholdsConfigurationId, pageable);
    }

    @GetMapping("/configurations/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DelayConfigurationDTO> getDelayConfigurationById(@PathVariable Long id) {
        logger.info("Received request for getDelayConfigurationById with id={}", id);
        DelayConfigurationDTO dto = service.getDelayConfigurationById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/configurations")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveDelayConfiguration(@Valid @RequestBody DelayConfigurationDTO dto) {
        logger.info("Received request to save DelayConfiguration: {}", dto);
        try {
            DelayConfigurationDTO savedDto = service.saveDelayConfiguration(dto);
            return ResponseEntity.ok(savedDto);
        } catch (RuntimeException e) {
            logger.error("Error saving DelayConfiguration: {}", e.getMessage());
            return ResponseEntity.status(400).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @PutMapping("/configurations/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateDelayConfiguration(
            @PathVariable Long id,
            @Valid @RequestBody DelayConfigurationDTO dto) {
        logger.info("Received request to update DelayConfiguration with id={}: {}", id, dto);
        try {
            dto.setId(id);
            DelayConfigurationDTO updatedDto = service.saveDelayConfiguration(dto);
            return ResponseEntity.ok(updatedDto);
        } catch (RuntimeException e) {
            logger.error("Error updating DelayConfiguration: {}", e.getMessage());
            return ResponseEntity.status(400).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("/configurations/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteDelayConfiguration(@PathVariable Long id) {
        logger.info("Received request to delete DelayConfiguration with id={}", id);
        try {
            service.deleteDelayConfiguration(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            logger.error("Error deleting DelayConfiguration: {}", e.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
}