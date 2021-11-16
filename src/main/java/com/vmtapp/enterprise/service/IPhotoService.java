package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dto.Photo;

import java.util.List;
import java.util.Optional;

public interface IPhotoService {
    List<Photo> fetchPhotoByTicketId(int id) throws Exception;
}
