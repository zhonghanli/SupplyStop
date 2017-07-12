package com.example.demo.service;

import com.example.demo.domain.Sponsor;
import com.example.demo.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by John on 7/11/2017.
 */
@Service
public class SponsorService {
    private SponsorRepository sponsorRepository;

    @Autowired
    public SponsorService(SponsorRepository sponsorRepository){this.sponsorRepository =sponsorRepository;}

    public String getSponsorName(int id){
       Sponsor sponsor = sponsorRepository.findById(id);

       return sponsor.getName();
        // return this.sponsorRepository.SponsorName(id);
    }

    public String getSponsorType(int id){
        return this.sponsorRepository.SponsorType(id);
    }

    public String getSponsorSize(int id){
        return this.sponsorRepository.SponsorSize(id);
    }
}
