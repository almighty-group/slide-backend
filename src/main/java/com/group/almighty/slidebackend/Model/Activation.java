package com.group.almighty.slidebackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Activation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 11, max = 11, message = "Phone number must be 11 digits")
    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @NotNull
    @Size(min = 6, max = 6, message = "Activation code must be 6 digits")
    @Column(unique = true, nullable = false)
    private String activationCode;

    private boolean isActivated;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd hh-mm-ss")
    private Date createdAt;

    public Activation() {
    }

    public Activation(long id, @NotNull @Size(min = 11, max = 11, message = "Phone number must be 11 digits") String phoneNumber, @NotNull @Size(min = 6, max = 6, message = "Activation code must be 6 digits") String activationCode, boolean isActivated, Date createdAt) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.activationCode = activationCode;
        this.isActivated = isActivated;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
