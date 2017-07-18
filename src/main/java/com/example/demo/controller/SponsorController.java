package com.example.demo.controller;

import com.example.demo.domain.Sponsor;
import com.example.demo.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Controller
@RequestMapping("/sponsors")
public class SponsorController {
    private SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService){ this.sponsorService = sponsorService;}


    //returns list of sponsors
    @RequestMapping("/")
    public String sponsors(Model model){
        List<Sponsor> s = sponsorService.getAllSponsors();
        model.addAttribute("sponsors",s);
        model.addAttribute("s",new Sponsor());
        return "sponsors";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String sponsorName(Model model, @PathVariable(value="id") int id){
        model.addAttribute("name", sponsorService.getSponsorName(id));
        model.addAttribute("type", sponsorService.getSponsorType(id));
        model.addAttribute("size", sponsorService.getSponsorSize(id));
        return "sponsorProfile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSponsor(@PathVariable(value="id") int id){
        this.sponsorService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String newSponsor(@ModelAttribute("s") Sponsor sponsor, Model model){
        sponsorService.save(sponsor);
        List<Sponsor> s = sponsorService.getAllSponsors();
        model.addAttribute("sponsors",s);
        return "sponsors";
    }
}
