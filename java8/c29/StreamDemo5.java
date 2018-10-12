package c29;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhaoTao on 2016/8/31.
 */
public class StreamDemo5 {

    public static void main(String[] args) {
        List<NamePhoneEmail> myList = new ArrayList<>();

        myList.add(new NamePhoneEmail("Larry", "1111", "lary!qqq"));
        myList.add(new NamePhoneEmail("Jame", "222", "2222!qqq"));


        System.out.println("Original:");
        myList.forEach(a -> System.out.println(a.name + " " + a.phonenum + " " + a.email));

        System.out.println();

        Stream<NamePhonePhone> nameAndPhone = myList.stream().map(a -> new NamePhonePhone(a.name, a.phonenum));

        System.out.println("List of names and phone:");
        //nameAndPhone.forEach(a-> System.out.println(a.name+" "+a.phonenum));

        List<NamePhonePhone> newList = nameAndPhone.collect(Collectors.toList());

        LinkedList<NamePhonePhone> npLIst = nameAndPhone.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);


        Stream<NamePhonePhone> phonePhoneStream = myList.stream().filter(a -> a.name.equals("Jame"))
                .map(a -> new NamePhonePhone(a.name, a.phonenum));

        phonePhoneStream.forEach(a -> System.out.println(a.name));


    }

}
