package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trip")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long tripId;

    @Column(nullable = false, length = 200)
    private String location;

    @Column()
    private Double price;

    @Lob
    private String itinerary;

    @Column(name = "available_slots")
    private Integer availableSlots;

    @Column(name = "trip_date")
    private LocalDate tripDate ;

    @ManyToOne()
    @JoinColumn(name = "agency_id",insertable=false, updatable=false)
    private Agency  agency;
    private  Long agency_id;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> review;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> booking;

    // Constructors, Getters, Setters

}
