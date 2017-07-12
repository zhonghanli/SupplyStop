package com.example.demo.repository;

import com.example.demo.domain.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by John on 7/11/2017.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>{
}
