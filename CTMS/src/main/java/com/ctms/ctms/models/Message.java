package com.ctms.ctms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private message_type sender_type;

    @Lob
    private String content;

    @Column()
    private LocalDateTime timestamp = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "agency_id",insertable=false, updatable=false)
    @JsonIgnore
    private Agency agency;
    private Long agency_id;

    @ManyToOne
    @JoinColumn(name = "customer_id",insertable=false, updatable=false)
    @JsonIgnore
    private Customer customer;
    private Long customer_id;
}
