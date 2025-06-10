package com.bankassurance.backend.client;

import com.bankassurance.backend.config.FeignConfig;
import com.bankassurance.backend.models.responses.LocationResponse;
import com.bankassurance.backend.models.utils.constants.ClientConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = ClientConstants.LOCALITY_API_NAME,
        url = ClientConstants.CLIENT_DEFAULT_URL,
        configuration = FeignConfig.class
)
public interface LocationClient {
    @GetMapping("/location")
    List<LocationResponse> search(
            @RequestParam(value = "CODPTT", required = false) String codeLocation
    );
}