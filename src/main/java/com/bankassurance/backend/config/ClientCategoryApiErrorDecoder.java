package com.bankassurance.backend.config;

import com.bankassurance.backend.models.utils.constants.ClientErrorConstants;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClientCategoryApiErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new RuntimeException(ClientErrorConstants.INVALID_REQUEST_MSG);
            case 404 -> new RuntimeException(ClientErrorConstants.CLIENT_ENDPOINT_NOT_FOUND_MSG);
            case 500 -> new RuntimeException(ClientErrorConstants.CLIENT_API_SERVER_ERROR_MSG);
            default -> new RuntimeException(ClientErrorConstants.DEFAULT_CLIENT_API_ERROR_MSG + response.status());
        };
    }
}