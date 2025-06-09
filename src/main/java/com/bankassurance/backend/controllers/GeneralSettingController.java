package com.bankassurance.backend.controllers;

import com.bankassurance.backend.repository.entity.GeneralSetting;
import com.bankassurance.backend.services.userservices.GeneralSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/settings/general")
@RequiredArgsConstructor
public class GeneralSettingController {

    private final GeneralSettingService service;

    @GetMapping
    public ResponseEntity<List<GeneralSetting>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<GeneralSetting> create(@RequestBody GeneralSetting setting) {
        return ResponseEntity.ok(service.create(setting));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralSetting> update(@PathVariable Integer id, @RequestBody GeneralSetting setting) {
        return service.update(id, setting)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
