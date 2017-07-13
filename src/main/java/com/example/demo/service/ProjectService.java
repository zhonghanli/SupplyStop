package com.example.demo.service;

import com.example.demo.domain.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository){this.projectRepository=projectRepository;}


    public String getSponsorName(int id){ return this.projectRepository.SponsorName(id);}

    public Project getCurrentProject(){ return this.projectRepository.findFirstByOrderByIdDesc();}

    public List<Project> list(){return this.projectRepository.findAllByOrderByIdDesc();}

}
