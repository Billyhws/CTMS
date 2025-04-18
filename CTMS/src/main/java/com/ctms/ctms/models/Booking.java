package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "trip_id",insertable=false, updatable=false)
    @JsonIgnore
    private Trip trip;
    private Long trip_id;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable=false, updatable=false)
    @JsonIgnore
    private Customer customer;
    private Long customer_id;
}
