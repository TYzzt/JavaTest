package c11;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("Main:" + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting Main thread");

    }
}
