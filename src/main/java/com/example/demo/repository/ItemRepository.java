package com.example.demo.repository;

import com.example.demo.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by John on 7/11/2017.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{
    List<Item> findAllByOrderByIdDesc();

    Item findById(Integer integer);
}
