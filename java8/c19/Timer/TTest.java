package c19.Timer;

import java.util.Timer;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class TTest {
    public static void main(String[] args) throws InterruptedException {
        MyTimerTask myTimerTask = new MyTimerTask();
        Timer myTimer = new Timer();

        myTimer.schedule(myTimerTask, 1000, 500);

        Thread.sleep(5000);

        myTimer.cancel();
    }

}
