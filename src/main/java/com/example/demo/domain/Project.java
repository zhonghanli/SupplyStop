package com.example.demo.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Min(value = 500, message = "Quantity should be over 500.")
    @Max(value = 10000, message = "Quantity should not exceed 10000!")
    private int quantity;

    @Min(value = 5, message = "Price should exceed 5 cents.")
    @Max(value = 100, message = "Price should not exceed 100 cents.")
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
