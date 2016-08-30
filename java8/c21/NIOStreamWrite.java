package c21;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/29.
 */
public class NIOStreamWrite {
    public static void main(String[] args) {
        try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("text.txt")))) {

            for (int i = 0; i < 26; i++) {
                fout.write((byte) ('A' + i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
