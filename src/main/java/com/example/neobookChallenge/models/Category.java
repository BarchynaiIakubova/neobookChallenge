package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cat_seq")
    @SequenceGenerator(sequenceName = "cat_seq", name = "cat_gen", allocationSize = 1)
    private Long id;

    private String title;

    private String image;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

}
