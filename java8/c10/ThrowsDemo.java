package c10;

/**
 * Created by ZhaoTao on 2016/6/28.
 */
public class ThrowsDemo {
    static void throwOne() throws IllegalAccessError {
        System.out.println("Inside thorw");
        throw new IllegalAccessError("demo");
    }

    public static void main(String[] args) {
        try {
            throwOne();
        } catch (IllegalAccessError e) {
            System.out.println("catch" + e);
        }
    }
}
