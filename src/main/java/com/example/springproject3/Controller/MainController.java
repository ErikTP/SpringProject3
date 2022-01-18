package com.example.springproject3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    /*
     * @GetMapping("/") public String home() { return "index"; }
     */



    /********************Formulär för att logga in användaren******************/
//    @GetMapping("userLoggedIn/{id}")
//    public String userLoggedIn(@PathVariable("id") Long id,
//                               Model model){
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "loggedIn";
//    }
//
//    @PostMapping("/loginUser")
//    public String loginUser(@RequestParam("name") String name,
//                            @RequestParam("password") String password
//    ){
//        User user = userService.getUserByName(name);
//        Long id = user.getId();
//
//        //Kontroll för att se ifall user existerar i databasen
//        if(user!= null && name.equals(user.getName()) && password.equals(user.getPassword())){
//            return "redirect:/userLoggedIn/" + id;
//        }
//
//        return "redirect:/failed";
//    }
//
    /*********Hanterar objekt istället för variabler (Sparar användaren)*********/
//    @GetMapping("/")
//    public String welcome(@ModelAttribute("user") User user){
//        return "user";
//    }
//
//    @GetMapping("/success")
//    public String success(@ModelAttribute("user") User user,
//                          Model model){
//        model.addAttribute("msg", "Du har sparats");
//        return "user";
//    }
//
//    @GetMapping("/failed")
//    public String failed(@ModelAttribute("user") User user,
//                         Model model){
//        model.addAttribute("msg", "Oj, något gick fel");
//        return "user";
//    }
//
//    @PostMapping("/saveUser")
//    public String saveUser(@RequestParam("password") String password,
//                           @RequestParam("passwordTwo") String passwordTwo,
//                           User user){
//
//        if (password.equals(passwordTwo)) {
//            user.setImg("https://via.placeholder.com/150");
//            userService.saveUser(user);
//            return "redirect:/success";
//        }
//
//        return "redirect:/failed";
//
//    }

    /*********Hanterar variabler istället för objekt (Sparar användaren)**********/
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

    /******************************Autentisering test***************************/
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
    /***********************************/

    /*****************Hanterar första exemplar för användarformuläret****************/
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


}
