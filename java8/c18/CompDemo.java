package c18;

import java.util.TreeSet;

/**
 * Created by ZhaoTao on 2016/7/12.
 */
public class CompDemo {
    public static void main(String[] args) {
      /*  TreeSet<String> ts = new TreeSet<>(new MyComp());*/
        TreeSet<String> ts = new TreeSet<>(new MyComp().reversed());
        ts.add("A");
        ts.add("C");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("A");
        ts.add("D");
        ts.add("A");

        ts.forEach(str -> System.out.println(str));

    }
}
