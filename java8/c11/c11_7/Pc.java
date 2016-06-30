package c11.c11_7;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class Pc {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop");
    }
}
