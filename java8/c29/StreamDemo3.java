package c29;

import java.util.ArrayList;

/**
 * Created by ZhaoTao on 2016/8/31.
 */
public class StreamDemo3 {
    public static void main(String[] args) {


        ArrayList<Double> myList = new ArrayList<>();

        myList.add(4.0);
        myList.add(16.0);

        double productOfSqrRoots = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b));


        //                                                         基础值，累加器，合并器
        double productOfSqrRoots2 = myList.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);

        System.out.println(productOfSqrRoots);

        System.out.println(productOfSqrRoots2);

    }
}
