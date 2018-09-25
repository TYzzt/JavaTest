package c11.c11_9;

/**
 * Created by ZhaoTao on 2016/7/1.
 */
public class NewThread implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    NewThread(String threadName) {
        t = new Thread(this, threadName);
        t.start();
        System.out.println("New thread:" + t);
        suspendFlag = false;
    }


    @Override
    public void run() {
        System.out.println("2222222222");
       /* try {
            System.out.println("11111");
            for(int i =15;i>0;i--){
                System.out.println(name+":"+i);
                Thread.sleep(200);
                synchronized (this){
                    while(suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(name + ":exit");

    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }


}
