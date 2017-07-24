package com.example.demo.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */

//Sponsors for the projects
@Entity
public class Sponsor {
    @Id @GeneratedValue
    private Integer id;

    @NotBlank(message = "Please enter a sponsor name.")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters.")
    private String name;

    //How large the business is, on a scale of "small", "medium", "large"
    @NotBlank(message = "Please enter the sponsor size.")
    private String size;

    //Type of business
    @NotBlank(message = "Please enter a sponsor type.")
    @Size(min = 2, max = 20, message = "Type should be between 2 and 20 characters.")
    private String type;


    @OneToMany(mappedBy = "sponsor", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Project> projects;

    //private, empty constructor
    public Sponsor() {
    }

    public Sponsor(String name, String size,  String type){
        this.name = name;
        this.size = size;
        this.type = type;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
