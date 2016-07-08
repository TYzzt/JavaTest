package c14;

/**
 * Created by ZhaoTao on 2016/7/6.
 */
public class GenMethDemo {

    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }

    //Comparable 接口的类定义了可被排序的对象

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5, 6};

        if (isIn(2, nums)) {
            System.out.println("2 is in");
        }

    }

}
