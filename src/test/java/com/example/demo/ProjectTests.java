package com.example.demo;

import com.example.demo.domain.Item;
import com.example.demo.domain.Location;
import com.example.demo.domain.Project;
import com.example.demo.domain.Sponsor;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.SponsorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by John on 7/13/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTests {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SponsorRepository sponsorRepository;
    @Autowired
    private LocationRepository locationRepository;

    public ProjectTests(){}

//    @Autowired
//    public ProjectTests(ProjectRepository projectRepository, ItemRepository itemRepository, SponsorRepository sponsorRepository, LocationRepository locationRepository){
//        this.projectRepository = projectRepository;
//        this.itemRepository = itemRepository;
//        this.sponsorRepository=sponsorRepository;
//        this.locationRepository=locationRepository;
//    }

    @Test
    public void ProjectTests(){
        Location location1 = new Location("1 Sherman Ave");
        Location location2 = new Location("2 Sherman Ave");
        Location location3 = new Location("3 Sherman Ave");
        Item item1 = new Item("Apples");
        Item item2 = new Item("Boxes");
        Item item3 = new Item("Cups");
        Sponsor sponsor1 = new Sponsor("Arbies", "large", "Restaurant");
        Sponsor sponsor2 = new Sponsor("Bennison's", "medium", "Restaurant");
        Sponsor sponsor3 = new Sponsor("Cheesies", "medium", "Restaurant");
        Project project1 = new Project(sponsor1, location1, item1, 1000, 15);
        Project project2 = new Project(sponsor2, location2, item2, 1000, 15);
        Project project3 = new Project(sponsor3, location3, item3, 1000, 15);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        sponsorRepository.save(sponsor1);
        sponsorRepository.save(sponsor2);
        sponsorRepository.save(sponsor3);
        locationRepository.save(location1);
        locationRepository.save(location2);
        locationRepository.save(location3);
        projectRepository.save(project1);
        projectRepository.save(project2);
        projectRepository.save(project3);

        Project currentProject = projectRepository.findFirstByOrderByIdDesc();
        //returns latest project
        assertThat(currentProject.getSponsor().getName()).isEqualTo("Cheesies");

        //List is in correct order, with the latest project at the front
        List<Project> projectList = projectRepository.findAllByOrderByIdDesc();
        assertThat(projectList.get(0).getSponsor().getName()).isEqualTo("Cheesies");
        assertThat(projectList.get(1).getSponsor().getName()).isEqualTo("Bennison's");
        assertThat(projectList.get(2).getSponsor().getName()).isEqualTo("Arbies");
    }
}
