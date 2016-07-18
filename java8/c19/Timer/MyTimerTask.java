package c19.Timer;

import java.util.TimerTask;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Timer Task executed;");
    }

}
