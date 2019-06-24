package com.group.almighty.slidebackend.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LoginDTO {

    @Min(value = 11, message = "Phone number must contain 11 characters.")
    @Max(value = 11, message = "Phone number must contain 11 characters.")
    @NotNull(message = "Phone number cannot be empty")
    private String phoneNumber;

    @Min(value = 6, message = "Password should not be less than 6 characters.")
    @NotNull(message = "Password field cannot be empty")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(@Min(value = 11, message = "Phone number must contain 11 characters.") @Max(value = 11, message = "Phone number must contain 11 characters.") @NotNull(message = "Phone number cannot be empty") String phoneNumber, @Min(value = 6, message = "Password should not be less than 6 characters.") @NotNull(message = "Password field cannot be empty") String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
