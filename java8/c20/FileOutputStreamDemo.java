package c20;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ZhaoTao on 2016/8/24.
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        String source = "Now is the time for all good men\n" +
                "to come to the aid of theri contry";

        byte buf[] = source.getBytes();

        try (FileOutputStream f0 = new FileOutputStream("file1.txt"); FileOutputStream f1 = new FileOutputStream("file2.txt");) {
            for (int i = 0; i < buf.length; i += 2) f0.write(buf[i]);

            f1.write(buf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
