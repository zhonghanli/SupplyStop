package com.example.demo.repository;

import com.example.demo.domain.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by John on 7/11/2017.
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
    @Query(value = "select s.name from Project p inner join Sponsor s on p.Sponsor_id = s.id where p.id = :id", nativeQuery = true)
    String SponsorName(@Param("id") int id);
}
