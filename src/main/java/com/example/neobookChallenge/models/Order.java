package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "or_seq")
    @SequenceGenerator(sequenceName = "or_seq", name = "or_gen")
    private Long id;

    private String phoneNumber;

    private String address;

    private String landmark;

    private String comments;

    private Long orderNumber;

    private LocalDateTime localDateTime;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProduct;


}
