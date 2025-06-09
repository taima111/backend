package com.bankassurance.backend.repository.configuration_entity;

import jakarta.persistence.*;

@Entity
@Table(name = "delay_configurations")
public class DelayConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "thresholds_configuration_id", referencedColumnName = "id")
    private ThresholdsConfiguration thresholdsConfiguration;

    private Integer delaiAnnulation;
    private Integer delaiResiliation;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ThresholdsConfiguration getThresholdsConfiguration() {
        return thresholdsConfiguration;
    }

    public void setThresholdsConfiguration(ThresholdsConfiguration thresholdsConfiguration) {
        this.thresholdsConfiguration = thresholdsConfiguration;
    }

    public Integer getDelaiAnnulation() {
        return delaiAnnulation;
    }

    public void setDelaiAnnulation(Integer delaiAnnulation) {
        this.delaiAnnulation = delaiAnnulation;
    }

    public Integer getDelaiResiliation() {
        return delaiResiliation;
    }

    public void setDelaiResiliation(Integer delaiResiliation) {
        this.delaiResiliation = delaiResiliation;
    }

    @Override
    public String toString() {
        return "DelayConfiguration{" +
                "id=" + id +
                ", thresholdsConfiguration=" + thresholdsConfiguration +
                ", delaiAnnulation=" + delaiAnnulation +
                ", delaiResiliation=" + delaiResiliation +
                '}';
    }
}