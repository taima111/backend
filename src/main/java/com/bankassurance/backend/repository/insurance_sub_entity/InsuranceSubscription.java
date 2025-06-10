package com.bankassurance.backend.repository.insurance_sub_entity;

import com.bankassurance.backend.models.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class InsuranceSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //agence::codug
    private String agence;
    //cliDelta
    private String idClient;
    //numcpt
    private String compte;

    private String assurance;

    private String nom;

    private String prenom;
    //typdoc_dir
    private String typeIdentity;
    //numdoc_dir
    private String numIdentity;
    //dna_dir
    private String dateNaiss;
    //LIEUNAISS
    private String lieuNaiss;
    //localité::CODPTT
    private String locality;
    //DATDOC
    private String dateDoc;
    //LIEUDOC
    private String lieuDoc;
    //Carte::NUMCPT
    private String card;

    private String profilClient;

    private Double primeCommerciale;

    private String motifValidation;

    private String motifReject;

    private LocalDateTime dateValidation;
    //Status
    @Enumerated(EnumType.STRING)
    private Status status;

    private String codAssurance;

    @OneToOne(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private SubscriptionCancellation cancellation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
}