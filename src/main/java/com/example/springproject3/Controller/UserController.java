package com.example.springproject3.Controller;

import com.example.springproject3.Entity.User;
import com.example.springproject3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /*****************Hanterar användarformuläret****************/
    /*
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
    */
    /***********************************/

    /*****************Hanterar objekt istället för variabler*****************/
    @GetMapping("/")
    public String welcome(@ModelAttribute("user") User user){
        return "user";
    }

    @GetMapping("/success")
    public String success(@ModelAttribute("user") User user,
                          Model model){
        model.addAttribute("msg", "Du har sparats");
        return "user";
    }

    @GetMapping("/failed")
    public String failed(@ModelAttribute("user") User user,
                         Model model){
        model.addAttribute("msg", "Oj, något gick fel");
        return "user";
    }
    /*********Fortsätter längre ner********/

    /*****************Hanterar variabler istället för objekt****************/
    /*
    @PostMapping("/saveUserParam")
    public String saveUserParam(@RequestParam("firstname") String firstname,
                                @RequestParam("lastname") String lastname,
                                @RequestParam("passwordOne") String passwordOne,
                                @RequestParam("passwordTwo") String passwordTwo
                                ) {

        if (passwordOne.equals(passwordTwo)) {
            User user = new User();
            user.setFirstname(firstname);
            user.setLastname(lastname);
            user.setPassword(passwordOne);
            userService.saveUser(user);
            return "redirect:/success";
        }

        return "redirect:/failed";

    }
    */
    /***********************************/

    /***********Fortsättning som hanterar objekt istället för variabler**********/
    @PostMapping("/saveUser")
    public String saveUser(@RequestParam("password") String password,
                           @RequestParam("passwordTwo") String passwordTwo,
                           User user){

        if (password.equals(passwordTwo)) {
            userService.saveUser(user);
            return "redirect:/success";
        }

        return "redirect:/failed";

    }

//    @PostMapping("/user/auth")
//    @ResponseBody
//    public Boolean authUser(@RequestBody User user){
//        return userService.authUser(user);
//    }

    /*
    @GetMapping("/login")
    public String loginView(@ModelAttribute("user") User user){
        return "login";
    }

    @PostMapping("/authenticate-user")
    public String authUser(@RequestParam String firstname,
                            @RequestParam String password) {
        if(userService.authUser(firstname, password)){
        return "redirect:/authenticated";
        }

        return "redirect:/authError";

    }

    @GetMapping("/authenticated")
    public String authenticated(Model model){
        model.addAttribute("msg", "You are logged in");
        return "login";
    }

    @GetMapping("/authError")
    public String authError(Model model){
        model.addAttribute("msg", "Login failed");
        return "login";
    }
*/

}




