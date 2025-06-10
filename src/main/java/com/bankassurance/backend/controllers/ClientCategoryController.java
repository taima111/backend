package com.bankassurance.backend.controllers;

import com.bankassurance.backend.client.ClientCategoriesClient;
import com.bankassurance.backend.models.responses.ClientCategoriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequiredArgsConstructor
public class ClientCategoryController {
    private final ClientCategoriesClient client;

    @GetMapping("/search")
    public List<ClientCategoriesResponse> search(@RequestParam(value = "code_category") String codeCategory
    ){
        return client.search(codeCategory);
    }
}
