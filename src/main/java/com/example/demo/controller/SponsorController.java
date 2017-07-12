package com.example.demo.controller;

import com.example.demo.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by John on 7/11/2017.
 */
@RestController
@RequestMapping("/sponsors")
public class SponsorController {
    private SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService){ this.sponsorService = sponsorService;}

    @RequestMapping("/{id}")
    public String sponsorName(@PathVariable(value="id") int id){
        return sponsorService.getSponsorName(id) + "\n" + sponsorService.getSponsorType(id) + "\n" + sponsorService.getSponsorSize(id);
    }

}
