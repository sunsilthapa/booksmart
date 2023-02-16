package  com.example.bookmarts.controller;

import com.example.bookmarts.entity.Cart;
import com.example.bookmarts.entity.User;
import com.example.bookmarts.pojo.CartPojo;
import  com.example.bookmarts.service.ShoppingCartService;
import  com.example.bookmarts.entity.Product;
import  com.example.bookmarts.service.ProductService;
import com.example.bookmarts.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
public class CartController {
//    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartController(ShoppingCartService shoppingCartService, ProductService productService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.userService = userService;
    }

//    @GetMapping("/cart")
//    public String cart(@PathVariable("id") Integer id,Model model){
//        model.addAttribute("products", shoppingCartService.findCartById(id));
////        model.addAttribute("totalPrice", shoppingCartService.totalPrice());
//
//        return "cart";
//    }

//    @PostMapping("/cart/add")
//    public String getFav(@Valid CartPojo cartPojo){
//        shoppingCartService.save(cartPojo);
//        return "redirect:/home";
//    }

    @GetMapping("/cart/{id}")
    public String getFavoriteinList(@PathVariable("id") Integer id, Model model, Principal principal) {
        List<Cart> cart=shoppingCartService.findCartById(id);
        model.addAttribute("favoriteList", cart);
        model.addAttribute("userdata",userService.findByEmail(principal.getName()));
        return "cart";}

    @GetMapping("/cart/add/{id}")
    public String addProductToCart(@PathVariable("id") Integer id, CartPojo cartPojo){
        Product product = productService.findById(id);
        if (product != null){
            shoppingCartService.save(cartPojo);
//            logger.debug(String.format("Product with id: %s added to shopping cart.", id));
        }
        return "redirect:/home";
    }

    @GetMapping("/deleteFav/{id}")
    public String deleteFavorite(@PathVariable("id") Integer id) {
        shoppingCartService.deleteById(id);
        return "redirect:/home";}

}
