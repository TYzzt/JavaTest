package c18;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by ZhaoTao on 2016/7/12.
 */
public class AlgorithmsDemo {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(-8);
        ll.add(-20);
        ll.add(20);
        ll.add(8);


        Comparator<Integer> r = Collections.reverseOrder();
        ll.sort((o1, o2) -> (o1 > o2) ? 1 : -1);      /*list.sort 排序*/

        ll.forEach(integer -> System.out.println(integer));

        Collections.sort(ll, r);

        ll.forEach(integer -> System.out.println(integer));

        Collections.shuffle(ll);   //随机化链表

        ll.forEach(integer -> {
            integer = 1;
            System.out.println(integer);
        });

        System.out.println(Collections.min(ll));

        /*list转数组*/
        Integer integers[] = new Integer[ll.size()];
        integers = ll.toArray(integers);



    }


}
