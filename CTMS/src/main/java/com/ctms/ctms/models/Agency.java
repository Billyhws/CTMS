package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "agency")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Agency{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private Long agencyId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 20,unique = true)
    private String phone;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(name = "unread_messages_count")
    private int unreadMessagesCount = 0;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Trip> trips;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Message> messages;


    // Constructors, Getters, Setters
}
