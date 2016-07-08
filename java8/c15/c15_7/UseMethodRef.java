package c15.c15_7;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
public class UseMethodRef {

    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> a1 = new ArrayList<>();

        a1.add(new MyClass(1));
        a1.add(new MyClass(4));
        a1.add(new MyClass(10));
        a1.add(new MyClass(3));

        MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMC);
        MyClass maxValObj2 = Collections.max(a1, (MyClass a, MyClass b) -> a.getVal() - b.getVal());

        System.out.println(maxValObj.getVal());
        System.out.println(maxValObj2.getVal());
    }

}
