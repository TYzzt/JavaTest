package c18;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ZhaoTao on 2016/7/12.
 */
public class CompDemo {
    public static void main(String[] args) {
      /*  TreeSet<String> ts = new TreeSet<>(new MyComp());*/

        /*带排序的Set*/

        TreeSet<String> ts = new TreeSet<>(new MyComp().reversed());
        ts.add("A");
        ts.add("C");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("A");
        ts.add("D");
        ts.add("A");

        ts.forEach(str -> System.out.println(str));

        Set<UserBean> set = new TreeSet<>((o1, o2) -> o2.getUserName().compareTo(o1.getUserName()));

        UserBean userBean = new UserBean();
        userBean.setA(1);
        userBean.setUserName("a");

        set.add(userBean);

        set.forEach(bean -> {
            bean.setUserName("name");
            System.out.println(bean.getUserName());
        });
        set.forEach(bean -> System.out.println(bean.getUserName()));

    }
}
