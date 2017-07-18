package com.example.demo.domain;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by John on 7/11/2017.
 */
@Entity
public class Project {

    @GeneratedValue @Id
    private Integer id;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Sponsor sponsor;

    //quantity of item and unit price
    private int quantity;
    private int price;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Project(){}

    public Project(Sponsor sponsor, Location location, Item item, int quantity, int price){
        this.sponsor = sponsor;
        this.location = location;
        this.item = item;
        this.quantity=quantity;
        this.price=price;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Sponsor getSponsor() {
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor) {
        this.sponsor = sponsor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
