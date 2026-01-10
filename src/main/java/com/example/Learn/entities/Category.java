package com.example.Learn.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private byte id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    private HashSet<Product> products = new HashSet<>();
}
