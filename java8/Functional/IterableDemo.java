package Functional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhaoTao on 2016/7/11.
 */
public class IterableDemo {
    public static void main(String[] args) {
/*        List<String> list = Arrays.asList(
                "a","b","c"
        );*/

        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");

        /**
         * 有条件的remove
         */

        list.removeIf(str -> {
            if (str.equals("a")) {
                return true;
            } else {
                return false;
            }
        });

        /**
         * 迭代
         */

        /*Iterable<String> ib = () -> list.iterator();
        ib.forEach(s -> System.out.println(s));*/

        list.forEach(s -> System.out.println(s));


    }
}
