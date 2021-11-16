package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Photo;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Profile("!test")
public interface PhotoRepository extends CrudRepository<Photo, Integer> {

    List<Photo> findByTicketId(int ticketId);
}
