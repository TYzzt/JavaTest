package 引论.practice;

import java.util.Arrays;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/9
 * \* Time: 8:54
 * \* Description:
 * \
 */
public class 选择排序 {

    public static void main(String[] args) {
        int arr[] = {1, 2, 6, 8, 5, 3, 7,10,11,39,28,4,331, 21, 16, 18, 15, 13, 17,110,111,139,128,14,313};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[]a)
    {
        int minIndex=0;
        int temp=0;
        if((a==null)||(a.length==0))
            return;
        for(int i=0;i<a.length-1;i++)
        {
            minIndex=i;//无序区的最小数据数组下标
            for(int j=i+1;j<a.length;j++)
            {
                //在无序区中找到最小数据并保存其数组下标
                if(a[j]<a[minIndex])
                {
                    minIndex=j;
                }
            }
            if(minIndex!=i)
            {
                //如果不是无序区的最小值位置不是默认的第一个数据，则交换之。
                temp=a[i];
                a[i]=a[minIndex];
                a[minIndex]=temp;
            }
        }
    }
}
