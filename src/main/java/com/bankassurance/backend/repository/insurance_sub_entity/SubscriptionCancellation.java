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
public class SubscriptionCancellation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    private InsuranceSubscription subscription;

    private String motifValidation;
    private String motifReject;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dateValidation;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime requestDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}