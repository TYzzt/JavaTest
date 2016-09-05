package c29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/9/2.
 */
public class StreamDemo7 {
    public static void main(String[] args) {

        List<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "1111", "lary!qqq"));
        myList.add(new NamePhoneEmail("Jame", "222", "2222!qqq"));


        Stream<NamePhonePhone> namePhonePhoneStream = myList.stream().map(a -> new NamePhonePhone(a.name, a.phonenum));

        List<NamePhonePhone> npList = namePhonePhoneStream.collect(Collectors.toList());

        System.out.println("Names and phone in a List:");

        Set<NamePhonePhone> npSet = namePhonePhoneStream.collect(Collectors.toSet());

        LinkedList<NamePhonePhone> npList2 = namePhonePhoneStream.collect(() -> new LinkedList<>(), (list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));


    }

}
