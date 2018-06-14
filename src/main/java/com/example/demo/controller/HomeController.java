package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Project;
import com.example.demo.domain.Sponsor;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by John on 7/11/2017.
 */

@Controller
public class HomeController {
    private ProjectService projectService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    public HomeController(ProjectService projectService){
        this.projectService=projectService;
    }

    @RequestMapping("/")
    public String home(Model model){
        Project project = projectService.getCurrentProject();
        Location location = project.getLocation();
        Item item = project.getItem();
        Sponsor sponsor = project.getSponsor();
        model.addAttribute("sponsor", sponsor.getName());
        model.addAttribute("item", item);
        model.addAttribute("location", location.getStreet()+", "+location.getTown()+" "+location.getState()+ " "+location.getZip());
        return "index";
    }



    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String showProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("sponsorList", projectService.listSponsors());
        model.addAttribute("itemList", projectService.listItems());
        model.addAttribute("locationList", projectService.listLocations());
        return "projectcreate/createProject";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createProject(@Valid Project project, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("sponsorList", projectService.listSponsors());
            model.addAttribute("itemList", projectService.listItems());
            model.addAttribute("locationList", projectService.listLocations());
            return "projectcreate/createProject";
        }
        projectService.save(project);
        return "projectcreate/projectCreatedPage";
    }
}
