package com.example.demo.service;

import com.example.demo.domain.Project;
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

    public Sponsor findById(Integer id){
        return this.sponsorRepository.findById(id);
    }

    public List<Sponsor> getAllSponsors(){ return this.sponsorRepository.findAllByOrderByIdDesc();}

    public void create(String name, String type, String size){
        Sponsor sponsor = new Sponsor(name, size, type);
        sponsorRepository.save(sponsor);
    }

    public void save(Sponsor sponsor){
        sponsorRepository.save(sponsor);
    }
//    Sponsor update(Integer integer, Sponsor sponsor);
//
    public void delete(Integer integer){
        sponsorRepository.delete(integer);
    };


}
