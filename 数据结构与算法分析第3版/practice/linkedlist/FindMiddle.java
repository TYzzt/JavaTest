package practice.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/10/17
 * \* Time: 8:58
 * \* Description:如何在一次遍历中找到单个链表的中值?
 * \
 */
public class FindMiddle {

    private static void ownFunction(List<Integer> list) {
        int size = list.size();
        int mid = 0;
        if (size % 2 == 0) {
            mid = (size + 1) / 2;
        } else {
            mid = size / 2;
        }
        System.out.println(list.get(mid));
    }

    public static void main(String[] args) {
        List<Integer> linkedList = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> linkedList2 = Arrays.asList(1, 2, 3, 4);
        ownFunction(linkedList);
        ownFunction(linkedList2);
    }

}
