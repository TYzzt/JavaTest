package c21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by ZhaoTao on 2016/8/29.
 */
public class NIOCopy {
    public static void main(String[] args) {

        Path source = Paths.get("text.txt");
        Path target = Paths.get("text2.txt");

        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
