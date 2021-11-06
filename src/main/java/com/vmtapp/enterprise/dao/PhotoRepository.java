package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Photo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    @Override
    Optional<Photo> findById(Integer integer);
}
