package c21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by ZhaoTao on 2016/8/30.
 */
public class PathDemo {
    public static void main(String[] args) {
        Path filepath = Paths.get("examples\\test.txt");

        System.out.println(filepath.getName(1));
        System.out.println(filepath);
        System.out.println(filepath.toAbsolutePath());
        System.out.println(filepath.getParent());

        if (Files.exists(filepath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File does not exist");
        }

        //Files.isHidden(filepath)
        try {
            BasicFileAttributes attributes = Files.readAttributes(filepath, BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
