package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pro_seq")
    @SequenceGenerator(name = "pro_gen", sequenceName = "pro_seq", allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    private Integer price;

    private String currencyAndInfo;

    private String image;

    @ManyToOne
    private Category category;

}
