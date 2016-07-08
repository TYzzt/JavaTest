package c15.c15_7;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
public class ConstructiorRefDemo {
    public static void main(String[] args) {
        MyFunc myclassCons = MyClass::new;

        //如果有泛型
        //MyFunc<Integer> myClassCons = MyClass<Integer>::new;

        MyClass mc = myclassCons.func(100);

        System.out.println(mc.getVal());
    }
}
