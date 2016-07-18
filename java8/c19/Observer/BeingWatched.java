package c19.Observer;

import java.util.Observable;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class BeingWatched extends Observable {

    void counter(int period) {
        for (; period >= 0; period--) {

            setChanged();  //调用通知前必须调用setchanged方法
            notifyObservers(new Integer(period));

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
