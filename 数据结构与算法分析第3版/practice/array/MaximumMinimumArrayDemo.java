package practice.array;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/10/16
 * \* Time: 9:29
 * \* Description:如何在未排序整数数组中找到最大值和最小值?
 * \
 */
public class MaximumMinimumArrayDemo {


    private static void ownFunction() {
        int testarray[] = {1, 3, 9, 4, 5, 61, 1, 3};
        System.out.println("max:" + Arrays.stream(testarray).max().getAsInt());
        System.out.println("min:" + Arrays.stream(testarray).min().getAsInt());

    }

    public static void main(String[] args) {
        ownFunction();

        largestAndSmallest(new int[]{-20, 34, 21, -87, 92,
                Integer.MAX_VALUE});
        largestAndSmallest(new int[]{10, Integer.MIN_VALUE, -2});
        largestAndSmallest(new int[]{Integer.MAX_VALUE, 40,
                Integer.MAX_VALUE});
        largestAndSmallest(new int[]{1, -1, 0});

    }

    public static void largestAndSmallest(int[] numbers) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number > largest) {
                largest = number;
            } else if (number < smallest) {
                smallest = number;
            }
        }

        System.out.println("Given integer array : " + Arrays.toString(numbers));
        System.out.println("Largest number in array is : " + largest);
        System.out.println("Smallest number in array is : " + smallest);
    }


}
