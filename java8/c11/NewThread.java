package c11;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread:" + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println("child" + n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting child thread");
    }
}
