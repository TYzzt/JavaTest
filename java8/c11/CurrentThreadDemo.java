package c11;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("CurrentThread:" + t);

        t.setName("My Thread");
        System.out.println("After:" + t);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
