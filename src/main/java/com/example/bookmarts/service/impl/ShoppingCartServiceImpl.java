package com.example.bookmarts.service.impl;

import com.example.bookmarts.entity.Cart;
import com.example.bookmarts.pojo.CartPojo;
import com.example.bookmarts.repository.CartRepository;
import com.example.bookmarts.repository.ProductRepository;
import com.example.bookmarts.repository.UserRepository;
import com.example.bookmarts.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private  final CartRepository cartRepository;
    private  final UserRepository userRepository;
    private  final ProductRepository productRepository;

    @Override
    public CartPojo save(CartPojo cartPojo) {
        Cart cart=new Cart();
        if(cartPojo.getId()!=null){
            cart.setId(cart.getId());
        }
        cart.setUser_id(userRepository.findById(cartPojo.getUser_id()));
        cart.setProduct_id(productRepository.findById(cartPojo.getProduct_id()));
        cartRepository.save(cart);
        return new CartPojo(cart);
    }

    @Override
    public List<Cart> findCartById(Integer id) {
        return findAllinList(cartRepository.findFavoriteById(id));
    }

    @Override
    public List<Cart> findAll() {
        return findAllinList(cartRepository.findAll());
    }
    public List<Cart> findAllinList(List<Cart> list){
        Stream<Cart> allJobsWithImage = list.stream().map(product ->    Cart.builder()
                .id(product.getId())
                .user_id(product.getUser_id())
                .product_id(product.getProduct_id())
                .build()
        );
        list = allJobsWithImage.collect(Collectors.toList());
        return list;
    }

    @Override
    public Cart findById(Integer id) {
        Cart cart=cartRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
        cart= Cart.builder()
                .id(cart.getId())
                .user_id(cart.getUser_id())
                .product_id(cart.getProduct_id())
                .build();
        return cart;
    }

    @Override
    public void deleteById(Integer id) {
        cartRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }
}