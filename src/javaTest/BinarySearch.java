package javaTest;

import java.util.LinkedList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/3/2
 * \* Time: 14:45
 * \* Description:
 * \
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 9, 5};
        paixu(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        List list = new LinkedList();

    }

    /**
     * 二分查找
     *
     * @param arr
     * @param x
     * @return
     */
    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int middle = high - low / 2;
            if (x == arr[middle]) {
                return middle;
            } else if (x < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void paixu(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                temp = arr[j];
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

}
