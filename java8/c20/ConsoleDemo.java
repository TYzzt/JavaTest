package c20;

import java.io.Console;

/**
 * Created by ZhaoTao on 2016/8/24.
 */
public class ConsoleDemo {
    public static void main(String[] args) {
        String str;
        Console con;

        con = System.console();

        if (con == null) return;

        str = con.readLine("aaaaaa");
        con.printf("aaaaaaa", str);

    }
}
