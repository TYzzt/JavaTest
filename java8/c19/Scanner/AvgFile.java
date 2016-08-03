package c19.Scanner;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ZhaoTao on 2016/8/1.
 */
public class AvgFile {
    public static void main(String[] args) throws IOException {
        int count = 0;
        double sum = 0.0;

        FileWriter fout = new FileWriter("Test.txt");
        fout.write("2 3.4 5 6 7.4 9.1 10.5 done");
        fout.close();

        FileReader fin = new FileReader("Test.txt");

        Scanner src = new Scanner(fin);

        while (src.hasNext()) {
            if (src.hasNextDouble()) {
                sum += src.nextDouble();
                count++;
            } else {
                String str = src.next();
                if (str.equals("done")) {
                    break;
                } else {
                    System.out.println("Data format error.");
                    return;
                }
            }
        }

        src.close();    //关闭src时，fin引用的文件会自动关闭
        //


        System.out.println("Average is " + sum / count);

    }
}
