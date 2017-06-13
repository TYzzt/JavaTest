package 设计模式.Singleton;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/5/12
 * \* Time: 10:07
 * \* Description:
 * \
 */
public class Singleton {
    //定义一个属性,用来保存Singleton类对象的实例
    private static Singleton instance;

    //私有构造器,该类不能被外部类使用new方式实例化
    private Singleton() {

    }

    public static Singleton getInstance() {
        //synchronized加锁同步会降低效率,这里先判断是否为空
        //不为空则不需要加锁,提高程序效率
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance();
    }
}
