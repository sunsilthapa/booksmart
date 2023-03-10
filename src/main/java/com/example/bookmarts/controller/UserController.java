package  com.example.bookmarts.controller;

import  com.example.bookmarts.entity.User;
import  com.example.bookmarts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPanel(Principal principal, Model model){
        User user = userService.findByUsername(principal.getName());

        if (user != null) {
            model.addAttribute("user", user);
        }else {
            return "error/404";
        }

        return "profile";
    }

    @GetMapping("/list")
    public String showUserList(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("userList", users);
        System.out.println(users);
        return "customer_details";
    }

//    @GetMapping("/list")
//    public String getUSerList(Model model) {
//        List<User> users = userService.fetchAll();
//
//        model.addAttribute("userList", users.stream().map(user ->
//                User.builder()
//                        .id(user.getId())
//                        .username(user.getUsername())
//                        .email(user.getEmail())
//                        .fullName(user.getFullName())
//                        .city(user.getCity())
//                        .build()
//
//        ));
//
////        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);
//
//        return "/customer_details";
//    }

    @GetMapping("/list/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Row delete successfully");
        return "redirect:/list";
    }
}
