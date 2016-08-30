package c21;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/30.
 */
public class DriList {
    public static void main(String[] args) {
        String dirname = "\\MyDir";

        try (DirectoryStream<Path> dirstrm = Files.newDirectoryStream(Paths.get(dirname))) {

            for (Path entry : dirstrm) {
                //...
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        ;

    }
}
