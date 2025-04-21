package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private message_type sender_type;

    @Lob
    private String content;

    @Column()
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "agency_id")
    @JsonIgnore
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;

}
