package c18;

import java.util.TreeSet;

/**
 * Created by ZhaoTao on 2016/7/11.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("C");
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("F");
        treeSet.add("E");
        treeSet.add("G");

        System.out.println(treeSet.subSet("A", "F"));  //不包含F


    }
}
