package c29;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/9/5.
 */
public class StreamDemo9 {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("D3");
        myList.add("D1");

        Stream<String> myStream = myList.stream();
        //并行迭代器
        Spliterator<String> stringSpliterator = myStream.spliterator();
        while (stringSpliterator.tryAdvance(n -> {
            System.out.println(n);
            if (n.equals("D")) {
                System.out.println("D get");
                stringSpliterator.forEachRemaining(a -> System.out.println("1" + a));
            }
        })) ;

     /*   stringSpliterator.forEachRemaining(n-> System.out.println(n));*/

    }

}
