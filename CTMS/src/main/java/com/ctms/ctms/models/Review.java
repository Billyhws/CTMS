package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TripRating rating;

    @Lob
    private String comment;

    @Column(name = "review_date")
    private LocalDateTime reviewDate = LocalDateTime.now();

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
