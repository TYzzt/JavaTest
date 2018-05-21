package 三表栈队列;

import java.util.Iterator;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/27
 * \* Time: 15:48
 * \* Description:
 * \
 */
public class ZDLTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        Iterator<Integer> it = myArrayList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        it.remove();
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
