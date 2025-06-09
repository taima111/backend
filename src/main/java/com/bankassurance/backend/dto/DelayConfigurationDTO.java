package com.bankassurance.backend.dto;

import jakarta.validation.constraints.NotNull;

public class DelayConfigurationDTO {
    private Long id;
    @NotNull(message = "ThresholdsConfigurationId cannot be null")
    private Long thresholdsConfigurationId;
    @NotNull(message = "DelaiAnnulation cannot be null")
    private Integer delaiAnnulation;
    @NotNull(message = "DelaiResiliation cannot be null")
    private Integer delaiResiliation;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getThresholdsConfigurationId() { return thresholdsConfigurationId; }
    public void setThresholdsConfigurationId(Long thresholdsConfigurationId) { this.thresholdsConfigurationId = thresholdsConfigurationId; }
    public Integer getDelaiAnnulation() { return delaiAnnulation; }
    public void setDelaiAnnulation(Integer delaiAnnulation) { this.delaiAnnulation = delaiAnnulation; }
    public Integer getDelaiResiliation() { return delaiResiliation; }
    public void setDelaiResiliation(Integer delaiResiliation) { this.delaiResiliation = delaiResiliation; }

    @Override
    public String toString() {
        return "DelayConfigurationDTO{" +
                "id=" + id +
                ", thresholdsConfigurationId=" + thresholdsConfigurationId +
                ", delaiAnnulation=" + delaiAnnulation +
                ", delaiResiliation=" + delaiResiliation +
                '}';
    }
}