package c19.Observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class Watcher implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update() called,count is " + arg);
    }
}
