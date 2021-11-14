package com.vmtapp.enterprise.service;

import com.vmtapp.enterprise.dao.IPhotoDAO;
import com.vmtapp.enterprise.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PhotoService implements IPhotoService{

    @Autowired
    private IPhotoDAO photoDAO;

    @Override
    public List<Photo> fetchPhotoByTicketId(int id) throws Exception {

        List<Photo> photos = photoDAO.fetchPhotoByTicketId(id);

        return photos;
    }
}
