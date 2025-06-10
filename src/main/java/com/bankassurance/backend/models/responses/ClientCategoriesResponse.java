package com.bankassurance.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientCategoriesResponse {
    @JsonProperty("COD_CATEG")
    private String code;

    @JsonProperty("LIB_CATEG")
    private String label;
}
