package com.bankassurance.backend.controllers;

import com.bankassurance.backend.client.AgencyClient;
import com.bankassurance.backend.models.responses.AgencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/qgence")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class AgencyController {
    private final AgencyClient client;

    @GetMapping("/search")
    public List<AgencyResponse> search(@RequestParam(value = "code_agence") String codeAgence
    ){
        return client.search(codeAgence);
    }
}
