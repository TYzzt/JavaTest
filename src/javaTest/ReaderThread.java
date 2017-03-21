package javaTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/2/14
 * \* Time: 8:48
 * \* Description:
 * \
 */
public class ReaderThread extends Thread {
    public void run() {
        System.out.println("run");
        while (!NoVisibility.ready) {
            System.out.println(NoVisibility.number);
        }
    }
}
