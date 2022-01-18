package com.example.springproject3.Controller;

import java.util.List;

import com.example.springproject3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springproject3.Entity.PostUser;
import com.example.springproject3.Service.PostUserService;

@Controller
public class PostUserController {

    @Autowired
    private PostUserService postUserService;

    // Renderar lista av PostUsers
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, model);
    }

    @GetMapping("/showNewPostUserForm")
    public String showNewPostUserForm(Model model) {
        // Skapar modellattribut för att binda formulärdata
        PostUser postUser = new PostUser();
        model.addAttribute("postUser", postUser);
        return "new_postuser";
    }

    @PostMapping("/savePostUser")
    public String savePostUser(@ModelAttribute("postUser") PostUser postUser) {
        // Sparar postUser till databasen
        postUserService.savePostUser(postUser);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // Hämta postUser från service
        PostUser postUser = postUserService.getPostUserById(id);

        // Tillsätta postUser som en modellattribut för att förfylla formuläret
        model.addAttribute("postUser", postUser);
        return "update_postuser";
    }

    @GetMapping("/deletePostUser/{id}")
    public String deletePostUser(@PathVariable (value = "id") long id) {

        // Tillkalla delete postUser metod
        this.postUserService.deletePostUserById(id);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page<PostUser> page = postUserService.findPaginated(pageNo, pageSize);
        List<PostUser> listpostUser = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listPostUser", listpostUser);
        return "index";
    }

    /***************************Hanterar jobbformuläret***************************/

    /*Hämtar info av alla jobb ("GET") och renderar en vy med formulär.
    @GetMapping("/showFormJob")
    public String showFormJob(@ModelAttribute("job") Job job,Model model){
        model.addAttribute("jobs", jobService.getAllJobs());
        return "job";
    }

    //Skickar information ("POST") till databasen som sparar jobb.
    @PostMapping("/saveJob")
    public String saveJob (@ModelAttribute("job") Job job){
        jobService.saveJob(job);
        return "redirect:/showFormJob";
    }
    */

}
