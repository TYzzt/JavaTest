package c18;

import java.util.PriorityQueue;

/**
 * Created by ZhaoTao on 2016/7/11.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(99);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());




  /*      priorityQueue.forEach(num-> System.out.println(num));

        Iterable<Integer> ib = ()->priorityQueue.iterator();
        ib.forEach(num->{
            System.out.println(num);
        });*/


    }
}
