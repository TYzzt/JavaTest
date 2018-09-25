package c15;

/**
 * Created by ZhaoTao on 2016/7/6.
 */
public class TestC15 {
    public static void main(String[] args) {
       /*()->Math.random()*100;*/
        //lambda表达式会自动创建实现了函数式接口的一个类的实例
        //return 123.45
        MyNumber myNum = () -> 123.45;
        System.out.println(myNum.getValue());
    }

    private static int i = 0;

    public static void testStr(String string) {
        System.out.println(++i + ":" + string);
    }

}
