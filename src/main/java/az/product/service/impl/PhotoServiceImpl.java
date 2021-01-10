package az.product.service.impl;

import az.product.config.UploadFolderConfig;
import az.product.model.db.Photo;
import az.product.repository.PhotoRepository;
import az.product.service.PhotoService;
import az.product.util.FileUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private UploadFolderConfig uploadFolderConfig;

    @Override
    public Photo addPhoto(Photo photo) {
        String filename = FileUtility.generateMediaFileName(uploadFolderConfig.getUploadFolder(), photo.getName());
        try{
        Path filePath = Paths.get(filename);
        if (!Files.exists(filePath.getParent())) {
          Files.createDirectory(filePath.getParent());
        }
        Files.copy(photo.getResource().getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        photo.setUrl(filename);
        photoRepository.addPhoto(photo);
    } catch (Exception e) {
        throw new RuntimeException("Error saving media", e);
    }

        return photo;
    }

    @Override
    public Optional<Photo> getPhotoByUrl(String url) {
        Optional<Photo> optionalPhoto = photoRepository.getPhotoByUrl(url);
        Photo photo = null;
        if (optionalPhoto.isPresent()){
             photo = optionalPhoto.get();

            Resource resource = null;

            try {
                resource = new FileUrlResource(photo.getUrl());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            photo.setResource(resource);
        }
        return Optional.of(photo);
    }

    @Override
    public Optional<Photo> getMediaById(long id) {
        Optional<Photo> optionalPhoto = photoRepository.getPhotoById(id);
        Photo photo = null;
        if (optionalPhoto.isPresent()){
            photo = optionalPhoto.get();

            Resource resource = null;

            try {
                resource = new FileUrlResource(photo.getUrl());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            photo.setResource(resource);
        }
        return Optional.of(photo);
    }
}
