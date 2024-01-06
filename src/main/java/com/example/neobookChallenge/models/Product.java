package com.example.neobookChallenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@EqualsAndHashCode
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

    private BigDecimal price;

    private String image;

    @ManyToOne
    private Category category;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Objects.equals(id, product.id); // Assuming id is a unique identifier for products
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }


}
