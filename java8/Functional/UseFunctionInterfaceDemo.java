package Functional;

import java.util.function.Function;

/**
 * Created by ZhaoTao on 2016/7/8.
 */
public class UseFunctionInterfaceDemo {
    public static void main(String[] args) {
        Function<Integer, Integer> function = (n) -> {
            int result = 1;
            for (int i = 1; i < n; i++) {
                result = i * result;
            }
            return result;
        };

        String a = "a";
        System.out.println(function.apply(3));

    }
}
