package az.product.model.db;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
    private long id;

    private String name;

    private long categoryId;

    private String description;

    private long photoId;

    private LocalDateTime idate;

    private LocalDateTime udate;


    public Product() {
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public LocalDateTime getIdate() {
        return idate;
    }

    public void setIdate(LocalDateTime idate) {
        this.idate = idate;
    }

    public LocalDateTime getUdate() {
        return udate;
    }

    public void setUdate(LocalDateTime udate) {
        this.udate = udate;
    }

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
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", description='" + description + '\'' +
                ", photoId='" + photoId + '\'' +
                ", idate=" + idate +
                ", udate=" + udate +
                '}';
    }
}
