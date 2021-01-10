package az.product.controller;

import az.product.model.db.Photo;
import az.product.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/photo/")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/{id}")
    public ResponseEntity<Resource> getMedia(@PathVariable(name = "id") long id) {
        ResponseEntity<Resource> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            Optional<Photo> optionalPhoto = photoService.getMediaById(id);
            if (optionalPhoto.isPresent()) {
                Photo photo = optionalPhoto.get();
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_TYPE, photo.getContentType());
                responseEntity = ResponseEntity.ok()
                        .headers(headers)
                        .body(photo.getResource());
                return responseEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }
}
