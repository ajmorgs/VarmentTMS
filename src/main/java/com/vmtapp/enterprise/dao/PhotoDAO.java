package com.vmtapp.enterprise.dao;

import com.vmtapp.enterprise.dto.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Repository
public class PhotoDAO implements IPhotoDAO {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void saveImage(MultipartFile imageFile, Photo photo) throws IOException {

        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);

    }

    @Override
    public List<Photo> fetchPhotoByTicketId(int id) {
        List<Photo> photos = photoRepository.findByTicketId(id);

        return photos;
    }
}
