package c14;

/**
 * Created by ZhaoTao on 2016/7/6.
 */
public class Stats<T extends Number> { //有界限泛型

    T[] nums;

    Stats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(Stats<?> ob) {  //通配符参数
        if (average() == ob.average()) {
            return true;
        } else return false;
    }

}
