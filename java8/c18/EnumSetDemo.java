package c18;

import c12.Apple;

import java.util.EnumSet;

/**
 * Created by ZhaoTao on 2016/7/13.
 */
public class EnumSetDemo {

    public static void main(String[] args) {

        EnumSet<Apple> enumSet = EnumSet.allOf(Apple.class);
        enumSet.add(Apple.Cortland);
        enumSet.add(Apple.GoldenDel);

    }
}
