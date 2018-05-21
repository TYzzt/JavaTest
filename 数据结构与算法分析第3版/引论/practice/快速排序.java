package 引论.practice;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/8
 * \* Time: 14:53
 * \* Description:
 * \
 */
public class 快速排序 {


    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 8, 5, 3, 7,10,11,39,28,4,331, 21, 16, 18, 15, 13, 17,110,111,139,128,14,313};
        quickSort(arr, 0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int s[],int l,int r) {
        if (l > r) {
            return;
        }
        int k = s[l]; //基准数
        int i = l;
        int j = r;
        int tmp;
        while (i < j) {
            while (s[j] > k && i < j) {
                j--;
            }
            while (s[i] < k && i < j) {
                i++;
            }
            if (i < j) {
                tmp = s[i];
                s[i] = s[j];
                s[j] = tmp;
            }
        }

        s[i] = k;

        quickSort(s,l,i-1);
        quickSort(s,j+1,r);

    }


}
