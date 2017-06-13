package javaTest;

import java.util.concurrent.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/24
 * \* Time: 14:15
 * \* Description:  线程池
 * \
 */
public class CallableAndFuture2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CompletionService<Integer> cs = new ExecutorCompletionService<>(threadPool);
        for (int i = 1; i < 5; i++) {
            final int taskID = i;
            cs.submit(() -> taskID);
        }
        // 可能做一些事情
        for (int i = 1; i < 5; i++) {
            try {
                System.out.println(cs.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        threadPool.shutdown();
    }
}
