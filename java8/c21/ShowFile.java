package c21;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/29.
 */
public class ShowFile {
    public static void main(String[] args) {
        int i;

        try (InputStream fin = Files.newInputStream(Paths.get("text.txt"))) {

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while (i != -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
