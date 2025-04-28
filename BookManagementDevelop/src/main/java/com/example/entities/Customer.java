package com.example.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @Column(length = 100)
    private String name;

    @Column(unique = true, length = 100)
    private String username;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 1000)
    private String password;



}