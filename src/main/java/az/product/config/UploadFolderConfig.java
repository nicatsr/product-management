package az.product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UploadFolderConfig {

    @Value("${upload.folder}")
    private String uploadFolder;

    public String getUploadFolder() {
        return uploadFolder;
    }

    public void setUploadFolder(String uploadFolder) {
        this.uploadFolder = uploadFolder;
    }

    @Override
    public String toString() {
        return "UploadFolderConfig{" +
                "uploadFolder='" + uploadFolder + '\'' +
                '}';
    }
}
