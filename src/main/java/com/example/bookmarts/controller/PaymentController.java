package  com.example.bookmarts.controller;

import com.example.bookmarts.entity.Payment;
import com.example.bookmarts.entity.User;
import com.example.bookmarts.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PaymentController {
//    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public String registration(Model model) {
        model.addAttribute("paymentForm", new Payment());

        return "pament";
    }

    @PostMapping("/payment")
    public String registration(@ModelAttribute("paymentForm") Payment paymentForm) {
//        if (bindingResult.hasErrors()) {
////            logger.error(String.valueOf(bindingResult.getFieldError()));
//            return "pament";
//        }
        paymentService.save(paymentForm);
        return "redirect:/home";
    }
    @GetMapping("/paylist")
    public String showUserList(Model model) {
        List<Payment> pays = paymentService.findAll();
        model.addAttribute("payList", pays);
        System.out.println(pays);
        return "payment_details";
    }

    @GetMapping("/paylist/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        paymentService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Data delete successfully");
        return "redirect:/paylist";
    }
}
