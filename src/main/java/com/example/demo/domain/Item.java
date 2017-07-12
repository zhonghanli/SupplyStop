package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.net.PortUnreachableException;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Entity
public class Item {
    @Id @GeneratedValue
    private Integer id;

    private int cost;

    private String type;

    @OneToMany(mappedBy = "item")
    private List<Project> projects;


    private Item(){}

    public Item(String type){
        this.type = type;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
