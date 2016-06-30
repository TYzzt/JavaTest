package c11.c11_7;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        valueSet = false;
        System.out.println("Got:" + n);
        notify();
        return n;
    }

    synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        valueSet = true;
        System.out.println("Put:" + n);
        notify();
    }
}
