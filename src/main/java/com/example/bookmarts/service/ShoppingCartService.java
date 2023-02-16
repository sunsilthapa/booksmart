package  com.example.bookmarts.service;


import com.example.bookmarts.entity.Cart;
import com.example.bookmarts.pojo.CartPojo;

import javax.validation.Valid;
import java.util.List;
public interface ShoppingCartService {
    CartPojo save( CartPojo cartPojo);
    List<Cart> findCartById(Integer id);
    List<Cart> findAll();
    Cart findById(Integer id);
    void deleteById(Integer id);
    boolean existsById(Integer id);
}


//import com.example.bookmarts.entity.Cart;
//import com.example.bookmarts.entity.Cart;
//import  com.example.bookmarts.entity.Product;
//import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;
//import java.util.Map;

//@Service
//public interface ShoppingCartService {
//
//
//        void addProduct(Product product);
//    void removeProduct(Product product);
//    void clearProducts();
//    Map<Product, Integer> productsInCart();
//    BigDecimal totalPrice();
//    void cartCheckout();
//
////    void addToCart(Cart cart);
//
////    List<Cart> findByUserId(String userId);
//}

