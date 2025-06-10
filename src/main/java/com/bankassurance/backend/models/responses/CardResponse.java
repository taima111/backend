package com.bankassurance.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardResponse {
    @JsonProperty("num_carte")
    private String numCarte;

    @JsonProperty("num_cpt")
    private String numCpt;

    @JsonProperty("cod_typ_carte")
    private String codTypCarte;

    @JsonProperty("lib_carte")
    private String libCarte;

    @JsonProperty("cod_etat_adh")
    private int codEtatAdh;

    @JsonProperty("date_deliv")
    private String dateDeliv;

    @JsonProperty("date_resiliation")
    private String dateResiliation;

    @JsonProperty("nom_titul_cpt")
    private String nomTitulCpt;

    @JsonProperty("typ_document")
    private String typDocument;

    @JsonProperty("num_document")
    private String numDocument;

    @JsonProperty("nom_porteur_carte")
    private String nomPorteurCarte;

    @JsonProperty("date_operation")
    private String dateOperation;

    @JsonProperty("codepro")
    private String codePro;

    @JsonProperty("fiche_cli")
    private String ficheCli;

    @JsonProperty("age_cpt")
    private String ageCpt;

    @JsonProperty("type_carte")
    private String typeCarte;
}
