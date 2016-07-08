package c15.c15_7;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
public class MyStringOps {
    static String strReverse(String str) {
        String result = "";
        int i;

        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
