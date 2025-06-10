package com.bankassurance.backend.models.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountResponse {
    @JsonProperty("CLIDELTA")
    private String cliDelta;

    @JsonProperty("CODBANQ")
    private String codBanq;

    @JsonProperty("CODUGBCT")
    private String codUgbct;

    @JsonProperty("NUMCPT")
    private String numCpt;

    @JsonProperty("CLEBCT")
    private String cleBct;

    @JsonProperty("CHAPITRECPT")
    private String chapitreCpt;

    @JsonProperty("CODACT")
    private String codAct;

    @JsonProperty("TYPCLI")
    private String typCli;

    @JsonProperty("RSO")
    private String rso;

    @JsonProperty("NOM_ADH")
    private String nomAdh;

    @JsonProperty("PRENOM_ADH")
    private String prenomAdh;

    @JsonProperty("TYPDOC_ADH")
    private String typDocAdh;

    @JsonProperty("NUMDOC_ADH")
    private String numDocAdh;

    @JsonProperty("NOM_DIR")
    private String nomDir;

    @JsonProperty("PRENOM_DIR")
    private String prenomDir;

    @JsonProperty("TYPDOC_DIR")
    private String typDocDir;

    @JsonProperty("NUMDOC_DIR")
    private String numDocDir;

    @JsonProperty("FORME_JURIDIQUE")
    private String formeJuridique;

    @JsonProperty("SECTEUR_ACTIVITE")
    private String secteurActivite;

    @JsonProperty("DATDOC")
    private String datDoc;

    @JsonProperty("LIEUDOC")
    private String lieuDoc;

    @JsonProperty("LIEUNAISS")
    private String lieuNaiss;

    @JsonProperty("SOLC")
    private String solc;

    @JsonProperty("CODPTT")
    private String codPtt;

    @JsonProperty("DNA_ADH")
    private String dnaAdh;

    @JsonProperty("DNA_DIR")
    private String dnaDir;

    @JsonProperty("DATECREATION")
    private String dateCreation;

    @JsonProperty("ADRESSE_DIR")
    private String adresseDir;

    @JsonProperty("DATCLO")
    private String datClo;

    @JsonProperty("DATOUV")
    private String datOuv;

    @JsonProperty("PROCLI")
    private String proCli;

    @JsonProperty("COMPTEJOINT")
    private String compteJoint;

    @JsonProperty("VILLE")
    private String ville;
}
