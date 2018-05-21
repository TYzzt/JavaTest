package javaTest;

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
/*        int[] arr = {1, 4, 3, 2, 6, 9, 5};
        paixu(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        List list = new LinkedList();*/
        printDiamond(7);
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


    public static void print(int size) {
        if (size % 2 == 0) {
            size++; // 计算菱形大小
        }
        for (int i = 0; i < size / 2 + 1; i++) {
            for (int j = size / 2 + 1; j > i + 1; j--) {
                System.out.print(" "); // 输出左上角位置的空白
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*"); // 输出菱形上半部边缘
            }
            System.out.println(); // 换行
        }
        for (int i = size / 2 + 1; i < size; i++) {
            for (int j = 0; j < i - size / 2; j++) {
                System.out.print(" "); // 输出菱形左下角空白
            }
            for (int j = 0; j < 2 * size - 1 - 2 * i; j++) {
                System.out.print("*"); // 输出菱形下半部边缘
            }
            System.out.println(); // 换行
        }
    }

    public static void printDiamond(int size) {

        size = (size / 2) * 2; // 菱形对角线两侧的宽度是相同的，所以对角线长度size必定是偶数,(size+1)即为行数和列数

        int center = (size / 2); // 以左上角为坐标点(0,0),菱形中心点坐标(center,center)

        for (int i = 0; i <= size; i++) { // 行
            for (int j = 0; j <= size; j++) { // 列
                if (Math.abs(i - center) + Math.abs(j - center) <= center) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


}
