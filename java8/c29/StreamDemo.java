package c29;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/8/30.
 */
public class StreamDemo {

    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(1);
        myList.add(20);
        myList.add(4);
        myList.add(90);

        System.out.println("Original：" + myList);

        Stream<Integer> myStream = myList.stream();

        Optional<Integer> minVal = myStream.min(Integer::compare);

        if (minVal.isPresent()) {
            System.out.println("Min:" + minVal.get());
        }

        myStream = myList.stream();
        Optional<Integer> maxVal = myStream.max(Integer::compare);

        if (maxVal.isPresent()) {
            System.out.println("Max:" + maxVal.get());
        }

        Stream<Integer> sortedStream = myList.stream().sorted();

        System.out.println("Sorted stream:");
        sortedStream.forEach(n -> System.out.print(n + " "));
        System.out.println();

        Stream<Integer> oddVals = myList.stream().sorted().filter(n -> (n % 2) == 1);

        System.out.println("Odd values:");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();

        oddVals = myList.stream().filter(n -> (n % 2) == 1).filter(((n) -> (n > 5)));

        System.out.println("Odd values greater than 5:");
        oddVals.forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

}
