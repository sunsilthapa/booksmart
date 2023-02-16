package com.example.bookmarts.pojo;


import com.example.bookmarts.entity.Cart;
import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartPojo {
    private Integer id;
    private  int product_id;
    private  int user_id;
    public CartPojo(Cart cart) {
        this.id=cart.getId();
        this.product_id= (int) cart.getProduct_id().getId();
        this.user_id= (int) cart.getUser_id().getId();
    }
}