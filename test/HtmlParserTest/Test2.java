package HtmlParserTest;

import java.sql.Timestamp;
import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/9/8
 * \* Time: 15:08
 * \* Description:
 * \
 */
public class Test2 {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Map map = new HashMap();
        map.put("time", timestamp);

        list.add(map);

        System.out.println(list.get(0).get("time"));
        /*System.out.println(new Date().getTime());*/
        System.out.println(1);

    }
}
