package 设计模式.subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 11:00
 * \* Description:
 * \
 */
public class Test {
    public static void main(String[] args) {
        Subject cs = new ConcreteSubject();
        //添加观察者
        cs.attach(new ConcreteObserver());
        cs.attach(new ConcreteObserver());
        //subject发生了某事，通知观察者
        cs.doSomeThings();
    }
}
