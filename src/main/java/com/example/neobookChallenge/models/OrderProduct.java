package com.example.neobookChallenge.models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oders_products")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bas_seq")
    @SequenceGenerator(name = "bas_gen", sequenceName = "bas_seq")
    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private String productImage;

    private Integer quantity;


    @ManyToOne
    private Order order;



}
