package javaTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/24
 * \* Time: 13:49
 * \* Description:
 * \
 */
public class CallableAndFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            Thread.sleep(1000);
            return 1;
        };
        FutureTask<Integer> future = new FutureTask<>(callable);
        Thread t = new Thread(future);
        t.start();
        //System.out.println(future.get());
        System.out.println(2);
        try {
            System.out.println(future.get()); //当get的时候就会wait到出现结果
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
