package 引论.菱形运算符;

import java.util.ArrayList;
import java.util.Collection;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/12/4
 * \* Time: 10:02
 * \* Description:
 * \
 */
public class TestClass {

    public static double totalArea(Collection<? extends Shape> arr) {
        double total = 0;
        for (Shape shape : arr) {
            if (shape != null) {
                total += shape.area();
            }
        }
        return total;
    }


    public static <T extends Comparable<T>> T findMax(T[] arr) {
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[maxIndex]) > 0) {
                maxIndex = i;
            }
        }
        return arr[maxIndex];
    }

    public static void main(String[] args) {
        Collection<Square> squares = new ArrayList<>();
        squares.add(new Square());
        squares.add(new Square());

        System.out.println(totalArea(squares));

    }

}
