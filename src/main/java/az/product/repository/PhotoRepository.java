package az.product.repository;

import az.product.model.db.Photo;

import java.util.Optional;

public interface PhotoRepository {

    Photo addPhoto(Photo photo);

    Optional<Photo> getPhotoByUrl(String url);

    Optional<Photo> getPhotoById(long id);
}
