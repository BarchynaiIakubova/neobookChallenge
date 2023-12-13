package com.example.neobookChallenge.models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pro_seq")
    @SequenceGenerator(name = "pro_gen", sequenceName = "pro_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    private String price;

    private String image;

    @ManyToOne
    private Category category;
}
