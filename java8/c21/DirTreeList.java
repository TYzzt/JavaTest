package c21;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by ZhaoTao on 2016/8/30.
 */
public class DirTreeList {
    public static void main(String[] args) {
        String dirname = "MyDir";

        System.out.println("Directory tree starting with " + dirname + ":\n");

        //遍历
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
