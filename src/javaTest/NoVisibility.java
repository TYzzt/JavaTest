package javaTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/2/14
 * \* Time: 8:37
 * \* Description:
 * \
 */
public class NoVisibility {
    volatile static boolean ready;
    volatile static int number;

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.yield();
        number = 42;
        ready = true;
    }
}
