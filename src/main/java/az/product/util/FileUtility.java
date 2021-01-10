package az.product.util;

import org.springframework.util.StringUtils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileUtility {

    public static String generateMediaFileName(String uploadFolder, String originalFileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String filename = String.format("%s%smedia-%s-%d.%s",
                uploadFolder,
                File.separator,
                LocalDateTime.now().format(formatter),
                LocalDateTime.now().getNano(),
                StringUtils.getFilenameExtension(originalFileName));
        return filename;
    }

}
