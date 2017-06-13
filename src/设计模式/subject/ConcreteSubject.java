package 设计模式.subject;

import java.util.ArrayList;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 10:59
 * \* Description:
 * \
 */
public class ConcreteSubject implements Subject {
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    public void doSomeThings() {
        //doSomeThings
        notifyObservers();//通知观察者
    }
}
