package com.group.almighty.slidebackend.Dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUserDTO {

    @NotNull(message = "Phone number cannot be null")
    @Size(min = 11, max = 11, message = "Phone number must contain 11 characters")
    private String phoneNumber;
    @NotNull(message = "Activation code cannot be null")
    @Size(min = 6, max = 6, message = "Activation code must contain 6 characters")
    private int activationCode;
    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "[^0-9]+[a-zA-z]*+[0-9]*[.-_&&[a-zA-z]*[0-9]*]?[a-zA-z]*@[a-zA-z]*.[a-z]+")
    private String email;
    @NotNull(message = "First name cannot be null")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    private String lastName;
    @NotNull(message = "Password cannot be null")
    private String password;
    @NotNull(message = "Confirm password cannot be null")
    private String confirmPassword;
    @NotNull(message = "Role Id cannot be null")
    private int roleId;

    public CreateUserDTO() {
    }

    public CreateUserDTO(@NotNull(message = "Phone number cannot be null") @Size(min = 11, max = 11, message = "Phone number must contain 11 characters") String phoneNumber, @NotNull(message = "Activation code cannot be null") @Size(min = 6, max = 6, message = "Activation code must contain 6 characters") int activationCode, @NotNull(message = "Email cannot be null") @Pattern(regexp = "[^0-9]+[a-zA-z]*+[0-9]*[.-_&&[a-zA-z]*[0-9]*]?[a-zA-z]*@[a-zA-z]*.[a-z]+") String email, @NotNull(message = "First name cannot be null") String firstName, @NotNull(message = "Last name cannot be null") String lastName, @NotNull(message = "Password cannot be null") String password, @NotNull(message = "Confirm password cannot be null") String confirmPassword, @NotNull(message = "Role Id cannot be null") int roleId) {
        this.phoneNumber = phoneNumber;
        this.activationCode = activationCode;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.roleId = roleId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(int activationCode) {
        this.activationCode = activationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
