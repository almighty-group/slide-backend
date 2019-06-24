package com.group.almighty.slidebackend.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ActivationDTO {
    @NotNull(message = "Phone number cannot be null")
    @Min(value = 11,message = "Phone number must be 11 digits.")
    @Max(value = 11, message = "Phone number must be 11 digits.")
    private String phoneNumber;

    @NotNull(message = "Activation code cannot be null")
    @Min(value = 6, message = "Activation code must contain 6 characters.")
    @Max(value = 6, message = "Activation code must contain 6 characters.")
    private String activationCode;

    public ActivationDTO() {
    }

    public ActivationDTO(@NotNull(message = "Phone number cannot be null") @Min(value = 11, message = "Phone number must be 11 digits.") @Max(value = 11, message = "Phone number must be 11 digits.") String phoneNumber, @NotNull(message = "Activation code cannot be null") @Min(value = 6, message = "Activation code must contain 6 characters.") @Max(value = 6, message = "Activation code must contain 6 characters.") String activationCode) {
        this.phoneNumber = phoneNumber;
        this.activationCode = activationCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
