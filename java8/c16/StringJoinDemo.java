package c16;

/**
 * Created by ZhaoTao on 2016/7/8.
 */
public class StringJoinDemo {
    public static void main(String[] args) {
        String result = String.join(" ", "AAA", "BBB", "CCC");
        System.out.println(result);
        result = String.join(",", "AAA", "BBB", "CCC");
        System.out.println(result);
    }
}
