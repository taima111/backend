package com.bankassurance.backend.client;

import com.bankassurance.backend.config.FeignConfig;
import com.bankassurance.backend.models.responses.AccountResponse;
import com.bankassurance.backend.models.utils.constants.ClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@FeignClient(
        name = ClientConstants.ACCOUNT_API_NAME,
        url = ClientConstants.CLIENT_DEFAULT_URL,
        configuration = FeignConfig.class
)
public interface AccountClient {

    @GetMapping("/compte")
    List<AccountResponse> getAll();

    @GetMapping("/compte")
    List<AccountResponse> search(
            @RequestParam(value = "CLIDELTA", required = false) String clientDelta,
            @RequestParam(value = "DNA_DIR", required = true) String birthDate,
            @RequestParam(value = "NUMDOC_DIR", required = true) String documentNumber
    );

    @GetMapping("/compte")
    List<AccountResponse> findByCliDeltaAndNumCpt(
            @RequestParam(value = "CLIDELTA", required = true) String clientDelta,
            @RequestParam(value = "NUMCPT", required = true) String numcpt
    );
}