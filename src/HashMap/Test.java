package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/12/11
 * \* Time: 10:05
 * \* Description:
 * \
 */
public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.putIfAbsent("a", 1);
        map.putIfAbsent("a", 2);
        System.out.println(map.toString());

        map = new HashMap();
        map.put("b", 1);
        map.putIfAbsent("b", 2);
        System.out.println(map.toString());

        map = new HashMap();
        map.computeIfAbsent("a", e -> {
            return e;
        });

        System.out.println(map.toString());

    }
}
