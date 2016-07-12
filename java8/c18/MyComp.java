package c18;

import java.util.Comparator;

/**
 * Created by ZhaoTao on 2016/7/12.
 */
public class MyComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
