package com.group.almighty.slidebackend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class RiderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "DOUBLE DEFAULT 0.0", nullable = false)
    private Double minimumTransactionVolume;

    @Column(columnDefinition = "DOUBLE DEFAULT 0.0", nullable = false)
    private Double maximumTransactionVolume;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date createdAt;

    public RiderGroup() {
    }


    public RiderGroup(long id, String name, Double minimumTransactionVolume, Double maximumTransactionVolume, Date createdAt) {
        this.id = id;
        this.name = name;
        this.minimumTransactionVolume = minimumTransactionVolume;
        this.maximumTransactionVolume = maximumTransactionVolume;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinimumTransactionVolume() {
        return minimumTransactionVolume;
    }

    public void setMinimumTransactionVolume(Double minimumTransactionVolume) {
        this.minimumTransactionVolume = minimumTransactionVolume;
    }

    public Double getMaximumTransactionVolume() {
        return maximumTransactionVolume;
    }

    public void setMaximumTransactionVolume(Double maximumTransactionVolume) {
        this.maximumTransactionVolume = maximumTransactionVolume;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
