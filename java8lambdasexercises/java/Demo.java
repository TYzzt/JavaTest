/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/14
 * \* Time: 10:19
 * \* Description:
 * \
 */
interface MyFuc<T> {
    boolean func(T t1, T t2);
}

public class Demo {
    private int var1;

    public Demo(int var1) {
        this.var1 = var1;
    }

    static boolean same2(Demo demo1, Demo demo2) {
        return demo1.getVar1() == demo2.getVar1();
    }

    static <T> boolean run(MyFuc<T> myfunc, T demo1, T demo2) {
        return myfunc.func(demo1, demo2);
    }

    public static void main(String[] args) {
        Demo demo1 = new Demo(1);
        Demo demo2 = new Demo(2);
        System.out.println(run(Demo::same, demo1, demo2)); //输出false
        System.out.println(run(Demo::same2, demo1, demo2)); //输出false
    }

    boolean same(Demo demo) {
        return this.var1 == demo.getVar1();
    }

    public int getVar1() {
        return this.var1;
    }
}
