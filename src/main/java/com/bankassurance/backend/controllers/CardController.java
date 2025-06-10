package com.bankassurance.backend.controllers;


import com.bankassurance.backend.client.CardClient;
import com.bankassurance.backend.models.responses.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/carte")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class CardController {
    private final CardClient client;

    @GetMapping("/search")
    public List<CardResponse> search(@RequestParam(value = "num_account") String numCpt
    ){
        return client.search(numCpt);
    }
}
