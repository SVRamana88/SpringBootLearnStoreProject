package com.example.Learn.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "village")
    private String village;

    @Column(name = "state")
    private String state;

    @Column(name = "pincode")
    private String pincode;
}
//NULLABLE FALSE IS NOT NEED SINCE THIS DB FIRST APPROACH