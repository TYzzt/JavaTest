package c29;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/10/12
 * \* Time: 8:52
 * \* Description:
 * \
 */
public class StreamTestCollects {


    public static void main(String[] args) {
        List<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "1111", "lary!qqq"));
        myList.add(new NamePhoneEmail("Jame", "222", "2222!qqq"));
        myList.add(new NamePhoneEmail(new String("Jame"), "333", "223333333qq"));

        Map<String, NamePhoneEmail> map = myList.stream().collect(Collectors.toMap(NamePhoneEmail::getPhonenum, Function.identity()));

        Map<String, NamePhoneEmail> map2 = myList.stream().collect(Collectors.toMap(NamePhoneEmail::getName, Function.identity(), (a, b) -> b, IdentityHashMap::new));
        AtomicInteger i = new AtomicInteger();
        Map<String, String> map5 = myList.stream().map(NamePhoneEmail::getPhonenum).collect(Collectors.toMap(Function.identity(), (a) -> String.valueOf(i.getAndIncrement())));
        int value = Stream.of(1, 2, 3, 4).findFirst().get();


        /*分组*/
        Map<String, List<NamePhoneEmail>> map3 = myList.stream().collect(Collectors.groupingBy(NamePhoneEmail::getName, Collectors.toList()));

        Map<String, List<String>> map4 = myList.stream().collect(Collectors.groupingBy(NamePhoneEmail::getName, Collectors.mapping(NamePhoneEmail::getPhonenum, Collectors.toList())));
        Map<String, Integer> map6 = myList.stream().collect(Collectors.groupingBy(NamePhoneEmail::getName, Collectors.reducing(0, e -> 1, Integer::sum)));
        Map<String, Integer> map6_1 = myList.stream().collect(Collectors.groupingBy(NamePhoneEmail::getName, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        System.out.println(value);


    }


}
