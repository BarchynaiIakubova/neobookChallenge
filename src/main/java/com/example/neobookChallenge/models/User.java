package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(sequenceName = "user_gen", name = "user_seq")
    private Long id;

    private String name;

    @OneToOne
    private Basket basket;

    @ManyToMany
    private List<Product> productList;

    public User(String name) {
        this.name = name;
    }


    //    List<Product> basket;


}
