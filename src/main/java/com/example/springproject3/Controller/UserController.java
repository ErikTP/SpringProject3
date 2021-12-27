package com.example.springproject3.Controller;

import com.example.springproject3.Entity.User;
import com.example.springproject3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*****************Hanterar användarformuläret****************/

    //Hämtar info av alla användare ("GET") och renderar en vy med formulär.
    @GetMapping("/welcome")
    public String welcome(@ModelAttribute("user") User user, Model model){
        model.addAttribute("users", userService.GetAllUsers());
        return "user";
    }

    //Skickar information ("POST") till databasen som sparar användare.
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
    userService.saveUser(user);
    return "redirect:/welcome";
    }

    //Via en th:action inom user template vägleds vi till en vy för pagetwo template.
    @GetMapping("/pagetwo")
    public String startpagetwo (){
        return "pagetwo";
    }


}




