package com.group.almighty.slidebackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "state", nullable = false, unique = true)
    private String stateName;

    @OneToMany(mappedBy = "state")
    @JsonBackReference
    @Column(nullable = false)
    private Set<BusStop> busStops;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public State() {
    }

    public State(long id, String stateName, Set<BusStop> busStops, Date createdAt, Date updatedAt) {
        this.id = id;
        this.stateName = stateName;
        this.busStops = busStops;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Set<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(Set<BusStop> busStops) {
        this.busStops = busStops;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
