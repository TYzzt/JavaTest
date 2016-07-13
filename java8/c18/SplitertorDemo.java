package c18;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * Created by ZhaoTao on 2016/7/13.
 */
public class SplitertorDemo {
    public static void main(String[] args) {
        List<Double> vals = new ArrayList<>();

        vals.add(1.0);
        vals.add(2.0);
        vals.add(4.0);
        vals.add(3.0);

        Spliterator<Double> spliterator = vals.spliterator();
        while (spliterator.tryAdvance(n -> System.out.println(n))) ;

    }
}
