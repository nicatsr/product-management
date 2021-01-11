package az.product.model.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class ProductDto {

    private long productId;

    private long photoId;

    @NotBlank(message = "{product.name.notBlank}")
    private String name;

    private long categoryId;

    @NotBlank(message = "{product.description.notBlank}")
    private String description;

    private MultipartFile photo;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", photoId=" + photoId +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                '}';
    }
}
