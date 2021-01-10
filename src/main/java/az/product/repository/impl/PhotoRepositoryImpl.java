package az.product.repository.impl;

import az.product.model.db.Photo;
import az.product.repository.PhotoRepository;
import az.product.repository.query.PhotoQuery;
import az.product.repository.rowmapper.PhotoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PhotoRepositoryImpl implements PhotoRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PhotoRowMapper photoRowMapper;

    @Override
    public Photo addPhoto(Photo photo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("url" , photo.getUrl());
        parameterSource.addValue("idate" , LocalDateTime.now());
        parameterSource.addValue("udate" , LocalDateTime.now());
        parameterSource.addValue("content_type" , photo.getContentType());
        int count = namedParameterJdbcTemplate.update(PhotoQuery.ADD_PHOTO ,parameterSource);
        if (count < 1){
            throw new RuntimeException("error adding photo");
        }
        return photo;
    }

    @Override
    public Optional<Photo> getPhotoByUrl(String url) {
        Optional<Photo> optionalPhoto = Optional.empty();
        Object[] args = new Object[]{url};
        List<Photo> photoList =
                jdbcTemplate.query(PhotoQuery.GET_PHOTO_BY_URL,photoRowMapper,args);
        if (!photoList.isEmpty()){
            optionalPhoto = Optional.of(photoList.get(0));
        }
        return optionalPhoto;
    }

    @Override
    public Optional<Photo> getPhotoById(long id) {
        Optional<Photo> optionalPhoto = Optional.empty();
        Object[] args = new Object[]{id};
        List<Photo> list = jdbcTemplate.query(PhotoQuery.GET_PHOTO_BY_ID ,photoRowMapper ,args);
        if (!list.isEmpty()){
            optionalPhoto = Optional.of(list.get(0));
        }
        return optionalPhoto;
    }
}
