//package com.group.almighty.slidebackend.Model;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//@Entity
//@Table(name = "rides")
//public class Ride {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "initial_state", nullable = false)
//    private State initialState;
//
//    @Column(name = "initial_bus_stop", nullable = false)
//    private BusStop initialBusStop;
//
//    @OneToMany(mappedBy = "state")
//    @JsonBackReference
//    @Column(name = "pass_through")
//    private Set<State> passThrough;
//
//    @OneToMany
//    @Column(name = "midway_transport_fare")
//    private Set<TransportFare> midWayTransportFare;
//
//    @Column(name = "final_state", nullable = false)
//    private State finalState;
//
//    @Column(name = "final_bus_stop", nullable = false)
//    private  BusStop finalBusStop;
//
//    private Platform platform;
//
//    private Driver driver;
//
//    @Column(name = "full_transport_fare", nullable = false)
//    private String fullTransportFare;
//
//    @Column(name = "number_of_seats", nullable = false)
//    private int numberOfSeats;
//
//    @Column(name = "remaining_seats")
//    private int remainingSeats;
//
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern = "YYYY-MM-dd hh:mm:ss")
//    @Column(name = "created_at")
//    private Date createdAt;
//
//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern = "YYYY-MM-dd hh:mm:ss")
//    @Column(name = "updated_at")
//    private Date updatedAt;
//
//    @JsonFormat(pattern = "YYYY-MM-dd hh:mm")
//    @Column(name = "ride_date")
//    private Date rideDate;
//
//    public Ride() {
//    }
//
//
//}
