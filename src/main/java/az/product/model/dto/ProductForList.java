package az.product.model.dto;

import az.product.model.db.Photo;

public class ProductForList {

    private long id;

    private String name;

    private String categoryName;

    private String description;

    private long photoId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    @Override
    public String toString() {
        return "ProductForList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", photoId=" + photoId +
                '}';
    }
}
