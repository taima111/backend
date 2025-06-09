package com.bankassurance.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PathConfigurationDTO {

    private Long id;
    private Long thresholdsConfigurationId; // Pour représenter uniquement l’ID
    private String assurance;               // Pour filtrage ou affichage côté frontend

    private String cheminGeneration;
    private String cheminStreamServe;
    private String nomFichierStreamServe;
    private String cheminArchivage;
    private String frequenceGenerationType;
}
