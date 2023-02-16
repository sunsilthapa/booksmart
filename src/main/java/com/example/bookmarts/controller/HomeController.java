package  com.example.bookmarts.controller;

import  com.example.bookmarts.entity.Product;
import com.example.bookmarts.pojo.CartPojo;
import  com.example.bookmarts.service.ProductService;
import com.example.bookmarts.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    private final ProductService productService;
    private final ShoppingCartService shoppingCartService;


    @Autowired
    public HomeController(ProductService productService, ShoppingCartService shoppingCartService) {
        this.productService = productService;
        this.shoppingCartService=shoppingCartService;
    }

    @GetMapping(value = {"/","/index","/home"})
    public String home(Model model){
        model.addAttribute("products", getAllProducts());
        model.addAttribute("productsCount", productsCount());
        return "home";
    }




    @GetMapping("/about")
    public String about(){
        return "about";
    }

    private List<Product> getAllProducts(){
        return productService.findAllByOrderByIdAsc();
    }

    private long productsCount(){
        return productService.count();
    }
}
