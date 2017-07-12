package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Entity
public class Location {

    @Id @GeneratedValue
    private Long id;

    private String street;
    private String town;
    private int zip;



    @OneToMany(mappedBy = "location")
    private List<Project> projects;

    private Location(){}

    public Location(String street){
        this.street = street;
        this.town = "Evanston";
        this.zip = 60201;
    }

    public Location(String street, String town, int zip){
        this.street = street;
        this.town = town;
        this.zip = zip;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
