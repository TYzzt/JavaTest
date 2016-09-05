package c29;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/9/5.
 */
public class StreamDemo10 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("D3");
        myList.add("D1");

        Stream<String> myStream = myList.stream();
        Spliterator<String> stringSpliterator = myStream.spliterator();

        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit();

        if (stringSpliterator1 != null) {
            stringSpliterator1.forEachRemaining(n -> System.out.println(n));
        }

        System.out.println("\nOutput from splitItr");
        stringSpliterator.forEachRemaining(n -> System.out.println(n));

    }
}
