package com.bankassurance.backend.repository.configuration_entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JokerInsuranceConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String insurer;
    private String insurance;
    private int clientProfile;
    private String contract;
    private String paymentMethod;
    private String productCode;
    private boolean autoRenewal;
    private int tva;
    private int ras;
    private int insurerFileFee;
    private int uibFileFee;
    private int maxSubscriptionAge;
    private int expirationAge;
    private String validationLevel;
    private String status;
    private int bankMargin;  // Corresponds to "margeBancaire"
    private int insurerMargin;  // Corresponds to "primeAssureur"

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
    public int getBankMargin() { return bankMargin; }
    public void setBankMargin(int bankMargin) { this.bankMargin = bankMargin; }
    public int getInsurerMargin() { return insurerMargin; }
    public void setInsurerMargin(int insurerMargin) { this.insurerMargin = insurerMargin; }
}