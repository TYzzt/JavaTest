package c29;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by ZhaoTao on 2016/8/31.
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();

        myList.add(1);
        myList.add(20);
        myList.add(4);
        myList.add(90);
        // a保存了当前结果，b保存了下一个元素
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);

        if (productObj.isPresent()) {
            System.out.println(productObj.get());
        }

        int product = myList.stream().reduce(2, (a, b) -> a * b);

        System.out.println(product);

    }
}
