package c13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ZhaoTao on 2016/7/5.
 */
public class ShowFile {
    public static void main(String[] args) {
        int i = 0;
        try (FileInputStream fin = new FileInputStream(args[0])) {    //资源约定，会自动关闭
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char) i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
