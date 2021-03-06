package com.example.demo.repository;

import com.example.demo.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{
    List<Location> findAllByOrderByIdDesc();
    Location findById(Integer integer);
}
