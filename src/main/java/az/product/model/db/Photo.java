package az.product.model.db;

import org.springframework.core.io.Resource;

import java.time.LocalDateTime;

public class Photo {

    private long id;

    private String url;

    private String name;

    private LocalDateTime idate;

    private LocalDateTime udate;

    private Resource resource;

    private String contentType;


    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", idate=" + idate +
                ", udate=" + udate +
                ", resource=" + resource +
                ", contentType=" + contentType +
                '}';
    }
}
