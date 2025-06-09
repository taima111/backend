package com.bankassurance.backend.controllers;

import com.bankassurance.backend.repository.configuration_entity.JokerInsuranceConfiguration;
import com.bankassurance.backend.services.userservices.JokerInsuranceConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joker-insurance-config")
public class JokerInsuranceConfigurationController {
    @Autowired
    private JokerInsuranceConfigurationService service;

    @PostMapping
    public JokerInsuranceConfiguration createOrUpdate(@RequestBody JokerInsuranceConfiguration config) {
        return service.createOrUpdate(config);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<JokerInsuranceConfiguration> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public JokerInsuranceConfiguration getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }
}