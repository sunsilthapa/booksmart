package com.example.bookmarts.entity;// src/main/java/com/example/entity/Cart.java

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @SequenceGenerator(name = "cart_seq_gen", sequenceName = "card_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "cart_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product_id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user_id;
}