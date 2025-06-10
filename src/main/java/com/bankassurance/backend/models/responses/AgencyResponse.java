package com.bankassurance.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgencyResponse {
    @JsonProperty("CODUG")
    private String codeUg;

    @JsonProperty("TYPUG")
    private String typeUg;

    @JsonProperty("LIBUG")
    private String labelUg;

    @JsonProperty("COD_UG_BCT")
    private String codeUgBct;

    @JsonProperty("CODZONE")
    private String codeZone;
}
