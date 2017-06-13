package 设计模式.subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 10:59
 * \* Description:
 * \
 */
//具体观察者
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("我观察到subject发生了某事");
    }
}