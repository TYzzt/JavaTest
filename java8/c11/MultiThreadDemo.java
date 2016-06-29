package c11;

/**
 * Created by ZhaoTao on 2016/6/29.
 */
public class MultiThreadDemo {
    public static void main(String[] args) {
        NewThread2 obj1 = new NewThread2("One");
        NewThread2 obj2 = new NewThread2("Two");
        NewThread2 obj3 = new NewThread2("Three");

        System.out.println("One isAlive:" + obj1.t.isAlive());
        System.out.println("Two isAlive:" + obj1.t.isAlive());
        System.out.println("Three isAlive:" + obj1.t.isAlive());

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            System.out.println("waiting for threads to finish.");
            obj1.t.join();
            obj2.t.join();
            obj3.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("One isAlive:" + obj1.t.isAlive());
        System.out.println("Two isAlive:" + obj1.t.isAlive());
        System.out.println("Three isAlive:" + obj1.t.isAlive());
        System.out.println("Main exit");
    }
}
