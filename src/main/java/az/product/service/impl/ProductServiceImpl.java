package az.product.service.impl;

import az.product.model.db.Category;
import az.product.model.db.Photo;
import az.product.model.db.Product;
import az.product.model.dto.ProductDto;
import az.product.model.dto.ProductForList;
import az.product.repository.ProductRepository;
import az.product.service.PhotoService;
import az.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PhotoService photoService;

    @Transactional
    @Override
    public void addProduct(ProductDto productDto) {
        Optional<Photo> photoFromDb = Optional.empty();
        Product product = new Product();
        // null for rest || content type check for normal controller
        if (productDto.getPhoto() == null
                || Objects.requireNonNull
                (productDto.getPhoto().getContentType()).contentEquals("application/octet-stream")){
            product.setPhotoId(productDto.getPhotoId());
        }else{
            photoFromDb = Optional.of(addPhotoDb(productDto));
            product.setPhotoId(photoFromDb.get().getId());
        }

        product.setName(productDto.getName());
        product.setCategoryId(productDto.getCategoryId());
        product.setDescription(productDto.getDescription());
        productRepository.addProduct(product);
    }

    @Override
    public List<Category> getCategoryList() {
        return productRepository.getCategoryList() ;
    }

    @Override
    public List<ProductForList> getProductList() {
        return productRepository.getProductList();
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public Optional<ProductForList> getProductById(long id) {
        return productRepository.getProductForListById(id);

    }

    @Override
    public long getCategoryIdByName(String categoryName) {
        return productRepository.getCategoryIdByName(categoryName);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = new Product();
        Optional<Photo> photoFromDb = Optional.empty();
        boolean photoExists = productRepository.photoExists(productDto.getPhotoId());
        if (photoExists && (productDto.getPhoto() == null
                || Objects.requireNonNull
                (productDto.getPhoto().getContentType()).contentEquals("application/octet-stream"))){
            // used current photo
            product.setPhotoId(productDto.getPhotoId());
        }else if (productDto.getPhoto() == null
                || Objects.requireNonNull
                (productDto.getPhoto().getContentType()).contentEquals("application/octet-stream")){
            // used default photo
            product.setPhotoId(productDto.getPhotoId());
        }else{
            // add new photo and set id
            photoFromDb = Optional.of(addPhotoDb(productDto));
            photoFromDb.ifPresent(photo -> product.setPhotoId(photo.getId()));
        }

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setCategoryId(productDto.getCategoryId());
        product.setId(productDto.getProductId());
        productRepository.updateProduct(product);

    }

    private Photo addPhotoDb(ProductDto productDto) {
        Photo photo = new Photo();
        Photo photoFromService;
        Optional<Photo> optionalPhotoFromDb;
        Photo photoFromDb;
        photo.setName(productDto.getPhoto().getOriginalFilename());
        photo.setResource(productDto.getPhoto().getResource());
        photo.setContentType(productDto.getPhoto().getContentType());

        photoFromService = photoService.addPhoto(photo);
        optionalPhotoFromDb = photoService.getPhotoByUrl(photoFromService.getUrl());
        photoFromDb = new Photo();

        if (optionalPhotoFromDb.isPresent()){
            photoFromDb = optionalPhotoFromDb.get();
        }
        return photoFromDb;
    }
}
