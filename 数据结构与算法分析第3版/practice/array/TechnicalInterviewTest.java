package practice.array;

import java.util.Arrays;
import java.util.BitSet;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/10/16
 * \* Time: 8:52
 * \* Description:
 * \
 */
public class TechnicalInterviewTest {


    public static void main(String[] args) {
        int testarray[] = {1, 3, 4, 5, 61, 1, 3};
        BitSet bitSet = new BitSet();
        Arrays.sort(testarray);
        for (int i : testarray) {
            if (!bitSet.get(i)) {
                bitSet.set(i);
                System.out.println(i);
            } else {
                System.out.println(0);
            }
        }
    }

/*    public static void main(String args[]) {

        int[][] test = new int[][]{
                {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
        }
    }*/

    /*
     * Method to remove duplicates from array in Java, without using
     * Collection classes e.g. Set or ArrayList. Algorithm for this
     * method is simple, it first sort the array and then compare adjacent
     * objects, leaving out duplicates, which is already in the result.
     */
    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        // Sorting array to bring duplicates together
        Arrays.sort(numbersWithDuplicates);

        int[] result = new int[numbersWithDuplicates.length];
        int previous = numbersWithDuplicates[0];
        result[0] = previous;

        for (int i = 1; i < numbersWithDuplicates.length; i++) {
            int ch = numbersWithDuplicates[i];

            if (previous != ch) {
                result[i] = ch;
            }
            previous = ch;
        }
        return result;

    }

}
