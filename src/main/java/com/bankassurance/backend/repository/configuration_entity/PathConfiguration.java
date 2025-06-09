package com.bankassurance.backend.repository.configuration_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "path_configurations")
public class PathConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thresholds_configuration_id", nullable = false)
    private ThresholdsConfiguration thresholdsConfiguration;

    @Column(name = "chemin_generation")
    private String cheminGeneration;

    @Column(name = "chemin_stream_serve")
    private String cheminStreamServe;

    @Column(name = "nom_fichier_stream_serve")
    private String nomFichierStreamServe;

    @Column(name = "chemin_archivage")
    private String cheminArchivage;

    @Column(name = "frequence_generation_type")
    private String frequenceGenerationType;
}
