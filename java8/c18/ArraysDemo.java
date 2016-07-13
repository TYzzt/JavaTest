package c18;

import java.util.Arrays;

/**
 * Created by ZhaoTao on 2016/7/13.
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = -3 * i;
        }

        System.out.println("Original contents:");
        display(array);

        Arrays.sort(array);
        System.out.println("Sort:");
        display(array);


        Arrays.fill(array, 2, 6, -1);

        System.out.println("fill():");
        display(array);

        Arrays.sort(array);
        System.out.println("Sort:");
        display(array);

        System.out.println("The value -9 is at location:");
        int index = Arrays.binarySearch(array, -9);
        System.out.println(index);

    }

    static void display(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
