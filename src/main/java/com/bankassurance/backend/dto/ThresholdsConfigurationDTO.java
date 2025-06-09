package com.bankassurance.backend.dto;

public class ThresholdsConfigurationDTO {
    private Long id;
    private String assurance;
    private int seuilMontant;
    private int seuilAge;
    private boolean maladie;
    private boolean compteJoint;
    private boolean rembNonMensuel;
    private boolean franchise;

    // Default constructor
    public ThresholdsConfigurationDTO() {}

    // Parameterized constructor
    public ThresholdsConfigurationDTO(Long id, String assurance, int seuilMontant, int seuilAge, boolean maladie,
                                      boolean compteJoint, boolean rembNonMensuel, boolean franchise) {
        this.id = id;
        this.assurance = assurance;
        this.seuilMontant = seuilMontant;
        this.seuilAge = seuilAge;
        this.maladie = maladie;
        this.compteJoint = compteJoint;
        this.rembNonMensuel = rembNonMensuel;
        this.franchise = franchise;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAssurance() { return assurance; }
    public void setAssurance(String assurance) { this.assurance = assurance; }
    public int getSeuilMontant() { return seuilMontant; }
    public void setSeuilMontant(int seuilMontant) { this.seuilMontant = seuilMontant; }
    public int getSeuilAge() { return seuilAge; }
    public void setSeuilAge(int seuilAge) { this.seuilAge = seuilAge; }
    public boolean isMaladie() { return maladie; }
    public void setMaladie(boolean maladie) { this.maladie = maladie; }
    public boolean isCompteJoint() { return compteJoint; }
    public void setCompteJoint(boolean compteJoint) { this.compteJoint = compteJoint; }
    public boolean isRembNonMensuel() { return rembNonMensuel; }
    public void setRembNonMensuel(boolean rembNonMensuel) { this.rembNonMensuel = rembNonMensuel; }
    public boolean isFranchise() { return franchise; }
    public void setFranchise(boolean franchise) { this.franchise = franchise; }
}