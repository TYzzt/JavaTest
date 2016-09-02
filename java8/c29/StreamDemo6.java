package c29;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ZhaoTao on 2016/8/31.
 */
public class StreamDemo6 {

    public static void main(String[] args) {
        List<Double> myList = new ArrayList<>();

        myList.add(4.0);
        myList.add(16.0);
        myList.add(1.0);

        IntStream cStrm = myList.stream().mapToInt(a -> (int) Math.ceil(a));

        cStrm.forEach(a -> System.out.println(a + " "));

    }

}
