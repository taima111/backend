package com.bankassurance.backend.controllers;

import com.bankassurance.backend.client.LocationClient;
import com.bankassurance.backend.models.responses.LocationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class LocationController {
    private final LocationClient client;

    @GetMapping("/search")
    public List<LocationResponse> search(
            @RequestParam(value = "codeLocation", required = true) String codeLocation
    ){
        return client.search(codeLocation);
    }
}
