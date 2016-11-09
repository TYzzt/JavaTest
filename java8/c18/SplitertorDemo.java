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
        vals.forEach(n -> System.out.println(n));    //list直接迭代
        Spliterator<Double> spliterator = vals.spliterator(); //JDK8新增的迭代器，支持并行迭代
        while (spliterator.tryAdvance(n -> System.out.println(n))) ;//tryAdvance省去了next()和hasNext()方法
    }
}
