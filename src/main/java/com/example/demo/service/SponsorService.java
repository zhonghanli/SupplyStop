package com.example.demo.service;

import com.example.demo.domain.Sponsor;
import com.example.demo.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    }

    public String getSponsorType(int id){
        return this.sponsorRepository.SponsorType(id);
    }

    public String getSponsorSize(int id){
        return this.sponsorRepository.SponsorSize(id);
    }

    public List<Sponsor> getAllSponsors(){ return this.sponsorRepository.findAllByOrderByIdDesc();}

    public void create(String name, String type, String size){
        Sponsor sponsor = new Sponsor(name, size, type);
        sponsorRepository.save(sponsor);
    }
//    Sponsor update(Integer integer, Sponsor sponsor);
//
    public void delete(Integer integer){
        sponsorRepository.delete(integer);
    };

}
