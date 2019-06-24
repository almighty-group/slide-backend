package com.group.almighty.slidebackend.Model;

import javax.persistence.*;

@Entity
@Table(name = "riders")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="rider_group_id", referencedColumnName = "id")
    private RiderGroup riderGroup;

    public Rider() {
    }

    public Rider(long id, User user, RiderGroup riderGroup) {
        this.id = id;
        this.user = user;
        this.riderGroup = riderGroup;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RiderGroup getRiderGroup() {
        return riderGroup;
    }

    public void setRiderGroup(RiderGroup riderGroup) {
        this.riderGroup = riderGroup;
    }
}
