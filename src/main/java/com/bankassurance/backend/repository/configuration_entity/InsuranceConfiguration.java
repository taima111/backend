package com.bankassurance.backend.repository.configuration_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class InsuranceConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Insurer cannot be blank")
    private String insurer;

    @NotBlank(message = "Insurance cannot be blank")
    private String insurance;

    @Min(value = 0, message = "Client profile must be a positive number")
    private int clientProfile;

    @NotBlank(message = "Contract cannot be blank")
    private String contract;

    @NotBlank(message = "Payment method cannot be blank")
    private String paymentMethod;

    @NotBlank(message = "Product code cannot be blank")
    private String productCode;

    @NotNull(message = "Auto renewal must be specified")
    private boolean autoRenewal;

    @Min(value = 0, message = "TVA must be a positive number")
    private int tva;

    @Min(value = 0, message = "RAS must be a positive number")
    private int ras;

    @Min(value = 0, message = "Insurer file fee must be a positive number")
    private int insurerFileFee;

    @Min(value = 0, message = "UIB file fee must be a positive number")
    private int uibFileFee;

    @Min(value = 0, message = "Max subscription age must be a positive number")
    private int maxSubscriptionAge;

    @Min(value = 0, message = "Expiration age must be a positive number")
    private int expirationAge;

    @NotBlank(message = "Validation level cannot be blank")
    private String validationLevel;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getInsurer() { return insurer; }
    public void setInsurer(String insurer) { this.insurer = insurer; }
    public String getInsurance() { return insurance; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
    public int getClientProfile() { return clientProfile; }
    public void setClientProfile(int clientProfile) { this.clientProfile = clientProfile; }
    public String getContract() { return contract; }
    public void setContract(String contract) { this.contract = contract; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public boolean isAutoRenewal() { return autoRenewal; }
    public void setAutoRenewal(boolean autoRenewal) { this.autoRenewal = autoRenewal; }
    public int getTva() { return tva; }
    public void setTva(int tva) { this.tva = tva; }
    public int getRas() { return ras; }
    public void setRas(int ras) { this.ras = ras; }
    public int getInsurerFileFee() { return insurerFileFee; }
    public void setInsurerFileFee(int insurerFileFee) { this.insurerFileFee = insurerFileFee; }
    public int getUibFileFee() { return uibFileFee; }
    public void setUibFileFee(int uibFileFee) { this.uibFileFee = uibFileFee; }
    public int getMaxSubscriptionAge() { return maxSubscriptionAge; }
    public void setMaxSubscriptionAge(int maxSubscriptionAge) { this.maxSubscriptionAge = maxSubscriptionAge; }
    public int getExpirationAge() { return expirationAge; }
    public void setExpirationAge(int expirationAge) { this.expirationAge = expirationAge; }
    public String getValidationLevel() { return validationLevel; }
    public void setValidationLevel(String validationLevel) { this.validationLevel = validationLevel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}