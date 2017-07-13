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
//        List<String> sponsors = new ArrayList<>();
//        Iterator<Sponsor> sponsorIterator = s.iterator();
//        while(sponsorIterator.hasNext()){
//            sponsors.add(sponsorIterator.next().getName());
//        }
        model.addAttribute("sponsors",s);
        return "sponsors";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String sponsorName(@PathVariable(value="id") int id){
        return sponsorService.getSponsorName(id) + "\n" + sponsorService.getSponsorType(id) + "\n" + sponsorService.getSponsorSize(id);
    }

}
