package az.product.service;


import az.product.model.db.Photo;

import java.util.Optional;

public interface PhotoService {

    Photo addPhoto(Photo photo);

    Optional<Photo> getPhotoByUrl(String url);

    Optional<Photo> getMediaById(long id);
}
