package com.bankassurance.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JokerInsuranceConfigurationDTO {

    private Long id;
    private String assureur;
    private String assurance;
    private String profilClient;
    private String contrat;
    private String versement;
    private String codeProduitDelta;
    private Boolean renouvellementAutomatique;
    private Double tva;
    private Double fraisDossierAssureur;
    private Double fraisDossierUIB;
    private Integer ageMaximumSouscription;
    private Integer ageEcheance;
    private String niveauValidation;
    private Boolean etat;
    private Double primeAssureur;
    private Double margeBanque;

    public static class DelayConfigurationDTO {
        private Long id;
        private String type; // e.g., "PAYMENT", "VALIDATION"
        private Integer days;
        private String description;

        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public Integer getDays() { return days; }
        public void setDays(Integer days) { this.days = days; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        @Override
        public String toString() {
            return "DelayConfigurationDTO{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", days=" + days +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}