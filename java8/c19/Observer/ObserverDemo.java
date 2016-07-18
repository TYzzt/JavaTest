package c19.Observer;

/**
 * Created by ZhaoTao on 2016/7/18.
 */
public class ObserverDemo {

    public static void main(String[] args) {
        BeingWatched observed = new BeingWatched();

        Watcher observing = new Watcher();

        observed.addObserver(observing);
        //observed.addObserver(observing2); 如果有多个观察者

        observed.counter(10);

    }

}
