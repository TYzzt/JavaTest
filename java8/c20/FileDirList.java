package c20;

import java.io.File;

/**
 * Created by ZhaoTao on 2016/8/3.
 */
public class FileDirList {
    public static void main(String[] args) {
        String dirname = "/java";
        File f1 = new File(dirname);

        if (f1.isDirectory()) {
            System.out.println("Directory of " + dirname);
            String s[] = f1.list();
            //。listFiles()返回File数组，也可以用FilenameFilter过滤

            //如果使用过滤功能
            // .list(FilenameFilter FFobj)

            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
            }
        }
    }
}
