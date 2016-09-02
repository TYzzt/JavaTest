package c29;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/8/31.
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        List<Double> myList = new ArrayList<>();

        myList.add(4.0);
        myList.add(16.0);
        myList.add(1.0);

        Stream<Double> sqrtRootStrm = myList.stream().map(a -> Math.sqrt(a));

        double productOfSqrtRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);

        System.out.println(productOfSqrtRoots);

    }
}
