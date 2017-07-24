package com.example.demo.controller;

import com.example.demo.domain.Project;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

/**
 * Created by John on 7/14/2017.
 */
@Controller
@RequestMapping("/projects")
public class ProjectController {
    private ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @RequestMapping("/")
    public String projects(Model model){
        List<Project> projects = projectService.list();
        model.addAttribute("projectList", projects);
        return "projects";
    }

    @RequestMapping("/{id}")
    public String projectInfo(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("p", projectService.findById(id));
        return "projectProfile";
    }
}
