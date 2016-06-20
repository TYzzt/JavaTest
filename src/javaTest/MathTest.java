package javaTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZhaoTao on 2016/2/24.
 */
public class MathTest {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                // task to run goes here
                System.out.println("Hello !!");
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.schedule(runnable,2,TimeUnit.SECONDS);
        executor.shutdown();
    }
    double a (int count){
        double x;
        //x-4+x+4+x/4+x*4=count;
        //6.25 * x=count;
        x=count/6.25;
        return x;
    }
}
