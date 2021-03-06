package com.example.demo.repository;

import com.example.demo.domain.Sponsor;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Repository
public interface SponsorRepository extends CrudRepository<Sponsor, Integer>{
//    @Query(value ="SELECT name FROM Sponsor where id = :id", nativeQuery =true)
//    String SponsorName(@Param("id") int id);

    Sponsor findById(Integer integer);

    List<Sponsor> findAllByOrderByIdDesc();
}
