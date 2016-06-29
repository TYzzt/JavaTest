package c11;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class NewThread2 implements Runnable {
    String name;
    Thread t;

    NewThread2(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread:" + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(name + ":" + n);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "Exit");
    }
}
