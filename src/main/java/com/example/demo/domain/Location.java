package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Entity
public class Location {

    @Id @GeneratedValue
    private Integer id;

    private String street;
    private String town;
    private int zip;
    private String state;



    @OneToMany(mappedBy = "location", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Project> projects;

    public Location(){}

    public Location(String street){
        this.street = street;
        this.town = "Evanston";
        this.zip = 60201;
        this.state = "IL";
    }

    public Location(String street, String town, int zip){
        this.street = street;
        this.town = town;
        this.zip = zip;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
