package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstname;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastname;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(length = 20, unique = true)
    private String phone;

    @Column(name = "unread_messages_count")
    private int unreadMessagesCount = 0;

    @Column(name = "book_status_count")
    private int unreadStatusCount = 0;

    @Column(nullable = false, length = 200)
    private String password;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Message> messages;

    // Constructors, Getters, Setters
}
