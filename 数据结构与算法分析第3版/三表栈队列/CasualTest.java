package 三表栈队列;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/4/10
 * \* Time: 9:49
 * \* Description:
 * \
 */
public class CasualTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("aba");
        list.add("bba");
        list.add("cba");
        list.add("dba");
        list.add("abaaaa");
        list.removeIf(s -> s.startsWith("a"));
        print(list);
    }

    public static <T> void print(Collection<T> c) {
        for (T t : c) {
            System.out.println(t);
        }
    }

}
