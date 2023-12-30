package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

    @ManyToMany
    private List<Product> basket;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    public User(String name) {
        this.name = name;
    }

    public void addProductToBasket(Product product) {

        if (this.basket == null) {

            this.basket = new ArrayList<>();
        }
        this.basket.add(product);
    }
}
