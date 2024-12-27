package com.example.JobApp;


import org.springframework.ui.Model;
import com.example.JobApp.model.JobPost;
import com.example.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;
    @GetMapping({"/", "home"})
    public String home(){
        return "home";
    }
    @GetMapping("addJob")
    public String addJob(){
        return "addJob";
    }
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }
    @GetMapping("viewAllJobs")
    public String viewAllJobs(Model m){
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);
        return "viewAllJobs";
    }
}
