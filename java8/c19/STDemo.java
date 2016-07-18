package c19;

import java.util.StringTokenizer;

/**
 * Created by ZhaoTao on 2016/7/15.
 */
public class STDemo {
    static String in = "title=Java:THe Complete Reference;" + "author=Schildt;";

    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer(in, "=;");

        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}
