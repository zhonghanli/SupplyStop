package com.example.demo.controller;

import com.example.demo.SupplystopApplication;
import com.example.demo.domain.Sponsor;
import com.example.demo.service.SponsorService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


/**
 * Created by John on 7/11/2017.
 */
@Controller
@RequestMapping("/sponsors")
public class SponsorController {
    private static final org.slf4j.Logger logger= LoggerFactory.getLogger(SupplystopApplication.class);

    private SponsorService sponsorService;

    @Autowired
    public SponsorController(SponsorService sponsorService){ this.sponsorService = sponsorService;}


    //returns list of sponsors
    @RequestMapping("/")
    public String sponsors(Model model){
        List<Sponsor> s = sponsorService.getAllSponsors();
        model.addAttribute("sponsors",s);
        model.addAttribute("sponsor",new Sponsor());
        return "sponsors";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String sponsorName(Model model, @PathVariable(value="id") int id){
        model.addAttribute("sponsor", sponsorService.findById(id));
        return "sponsorProfile";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSponsor(@PathVariable(value="id") int id){
        logger.info("Deleted Sponsor with name: " + sponsorService.findById(id).getName());
        this.sponsorService.delete(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String newSponsor(@Valid Sponsor sponsor, BindingResult bindingResult, Model model){
        logger.info("Has errors="+bindingResult.hasErrors());
        if(bindingResult.hasErrors()){
            List<Sponsor> s = sponsorService.getAllSponsors();
            model.addAttribute("sponsors",s);
            return "sponsors";
        }

        sponsorService.save(sponsor);
        logger.info("Created a new sponsor with name: "+sponsor.getName());
        List<Sponsor> s = sponsorService.getAllSponsors();
        model.addAttribute("sponsors",s);
        return "sponsors";
    }
}
