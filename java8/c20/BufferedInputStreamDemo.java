package c20;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by ZhaoTao on 2016/8/24.
 */
public class BufferedInputStreamDemo {
    public static void main(String[] args) {
        String s = "This is a &copy";

        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());

        int c;
        try (BufferedInputStream f = new BufferedInputStream(in)) {

            while ((c = f.read()) != -1) {
                System.out.println((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
