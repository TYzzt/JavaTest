package c29;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/9/5.
 */
public class StreamDemo8 {
    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        myList.add("D3");
        myList.add("D1");

        Stream<String> myStream = myList.stream();
        Iterator<String> itr = myStream.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
