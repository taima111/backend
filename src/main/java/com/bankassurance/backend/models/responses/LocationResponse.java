package com.bankassurance.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocationResponse {
    @JsonProperty("CODPTT")
    private String code;

    @JsonProperty("LIBPTT")
    private String label;
}
