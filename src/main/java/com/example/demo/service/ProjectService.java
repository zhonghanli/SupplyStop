package com.example.demo.service;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Project;
import com.example.demo.domain.Sponsor;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Service
public class ProjectService {
    private ProjectRepository projectRepository;
    private ItemRepository itemRepository;
    private SponsorRepository sponsorRepository;
    private LocationRepository locationRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository, ItemRepository itemRepository, SponsorRepository sponsorRepository, LocationRepository locationRepository){
        this.projectRepository=projectRepository;
        this.itemRepository=itemRepository;
        this.sponsorRepository = sponsorRepository;
        this.locationRepository = locationRepository;
    }


    public String getSponsorName(int id){ return this.projectRepository.SponsorName(id);}

    public Project getCurrentProject(){ return this.projectRepository.findFirstByOrderByIdDesc();}

    public List<Project> list(){return this.projectRepository.findAllByOrderByIdDesc();}

    public List<Item> listItems(){return this.itemRepository.findAllByOrderByIdDesc();}

    public List<Sponsor> listSponsors(){
        return this.sponsorRepository.findAllByOrderByIdDesc();
    }
    public List<Location> listLocations(){return this.locationRepository.findAllByOrderByIdDesc();}

    public Sponsor loadSponsor(Integer integer){
        return this.sponsorRepository.findById(integer);
    }
    public Item loadItem(Integer integer){
        return this.itemRepository.findById(integer);
    }
    public Location loadLocation(Integer integer){
        return this.locationRepository.findById(integer);
    }

    public void create(Sponsor sponsor, Location location, Item item, int quantity, int price){
        Project project = new Project(sponsor, location, item, quantity, price);

        //sets date to current time
        Date date = new Date();
        project.setDate(date);

        projectRepository.save(project);
    }

    public void save(Project project){
        projectRepository.save(project);
    }
}
