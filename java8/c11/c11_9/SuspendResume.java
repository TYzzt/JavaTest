package c11.c11_9;

/**
 * Created by ZhaoTao on 2016/7/1.
 */
public class SuspendResume {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        /*try {
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Suspending thread one");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resuming thread one");
            ob2.mysuspend();
            System.out.println("Suspending thread two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Resuming thread two");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            ob2.t.join();
            ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread exiting.");


    }
}
