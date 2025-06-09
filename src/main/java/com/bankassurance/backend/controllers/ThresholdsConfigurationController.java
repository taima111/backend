package com.bankassurance.backend.controllers;
import com.bankassurance.backend.services.userservices.ThresholdsConfigurationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.bankassurance.backend.dto.ThresholdsConfigurationDTO;

@RestController
@RequestMapping("/api/threshold-configurations")
class ThresholdConfigurationController {
    private final ThresholdsConfigurationService service;

    public ThresholdConfigurationController(ThresholdsConfigurationService service) {
        this.service = service;
    }

    @GetMapping
    public List<ThresholdsConfigurationDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ThresholdsConfigurationDTO create(@RequestBody ThresholdsConfigurationDTO config) {
        return service.create(config);
    }

    @PutMapping("/{id}")
    public ThresholdsConfigurationDTO update(@PathVariable Long id, @RequestBody ThresholdsConfigurationDTO config) {
        return service.update(id, config);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}