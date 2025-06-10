package com.bankassurance.backend.client;

import com.bankassurance.backend.config.FeignConfig;
import com.bankassurance.backend.models.responses.AccountResponse;
import com.bankassurance.backend.models.responses.ClientCategoriesResponse;
import com.bankassurance.backend.models.utils.constants.ClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(
        name = ClientConstants.CLIENT_CATEGORIES_API_NAME,
        url = ClientConstants.CLIENT_DEFAULT_URL,
        configuration = FeignConfig.class
)
public interface ClientCategoriesClient {
    @GetMapping("/categ_clients")
    List<AccountResponse> getAll();

    @GetMapping("/categ_clients")
    List<ClientCategoriesResponse> search(@RequestParam("COD_CATEG") String code);
}

