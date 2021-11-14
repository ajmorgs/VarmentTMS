package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IPhotoDAO {
    void save(Photo photo);

    void saveImage(MultipartFile imageFile, Photo photo) throws IOException;

    List<Photo> fetchPhotoByTicketId(int id);
}
