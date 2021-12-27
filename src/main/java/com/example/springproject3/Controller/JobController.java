package com.example.springproject3.Controller;

import com.example.springproject3.Entity.Job;
import com.example.springproject3.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    /*****************Hanterar jobbformuläret****************/

    //Hämtar info av alla jobb ("GET") och renderar en vy med formulär.
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

}
