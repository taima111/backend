package com.bankassurance.backend.controllers;

import com.bankassurance.backend.client.AccountClient;
import com.bankassurance.backend.models.responses.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/compte")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class AccountController {
    private final AccountClient client;

    @GetMapping
    public List<AccountResponse> getAll(){
        return client.getAll();
    }

    @GetMapping("/clidelta/{cliDelta}")
    public List<AccountResponse> findByCliDelta(
            @PathVariable(value = "cliDelta", required = false) String clientDelta)
    {
        return client.search(clientDelta,"","");
    }

    @GetMapping("/search")
    public List<AccountResponse> search(
            @RequestParam(value = "client_id", required = false) String clientDelta,
            @RequestParam(value = "birthdate", required = true) String birthDate,
            @RequestParam(value = "identity_num", required = true) String documentNumber
    ){
        boolean allEmpty = Stream.of(clientDelta, birthDate, documentNumber)
                .allMatch(param -> param == null || param.trim().isEmpty());

        if (allEmpty) {
            return Collections.emptyList();
        }
        return client.search(clientDelta,birthDate,documentNumber);
    }
}
