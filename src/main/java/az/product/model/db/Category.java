package az.product.model.db;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Category {

    private long id;

    private String name;

    private LocalDateTime idate;

    private LocalDateTime udate;

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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idate=" + idate +
                ", udate=" + udate +
                '}';
    }
}
