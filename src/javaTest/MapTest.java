package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/7/4
 * \* Time: 9:15
 * \* Description:
 * \
 */
public class MapTest {


    public static void main(String[] args) {
        List<ACMEBicycle> list = new ArrayList<>();
        ACMEBicycle acmeBicycle = new ACMEBicycle();
        acmeBicycle.cadence = 1;
        list.add(acmeBicycle);
        acmeBicycle = new ACMEBicycle();
        acmeBicycle.cadence = 2;
        list.add(acmeBicycle);
        acmeBicycle = new ACMEBicycle();
        acmeBicycle.cadence = 3;
        list.add(acmeBicycle);

        Map<Integer, List<ACMEBicycle>> map = list.stream().collect(Collectors.groupingBy(ACMEBicycle::getCadence));
        map.computeIfPresent(1, new BiFunction<Integer, List<ACMEBicycle>, List<ACMEBicycle>>() {
            @Override
            public List<ACMEBicycle> apply(Integer integer, List<ACMEBicycle> acmeBicycles) {
                return new ArrayList<>();
            }
        });
        System.out.println(1);
        map.computeIfPresent(4, new BiFunction<Integer, List<ACMEBicycle>, List<ACMEBicycle>>() {
            @Override
            public List<ACMEBicycle> apply(Integer integer, List<ACMEBicycle> acmeBicycles) {
                System.out.println(acmeBicycles.get(0));
                return null;
            }
        });
        System.out.println(1);

        System.out.println((int) (11 * 0.5));
        System.out.println((int) (11 * 0.2));
        System.out.println((int) (11 * 0.3));


    }

}
