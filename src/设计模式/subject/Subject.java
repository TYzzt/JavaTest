package 设计模式.subject;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/17
 * \* Time: 10:58
 * \* Description:
 * \
 */
public interface Subject {
    //添加观察者
    void attach(Observer o);

    //删除观察者
    void detach(Observer o);

    //通知观察者
    void notifyObservers();

    //发生某事
    void doSomeThings();
}
