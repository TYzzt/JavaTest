package c15.c15_7;

/**
 * Created by ZhaoTao on 2016/7/7.
 */
/*eg*/
public interface StringFunc {
    String func(String n);

    default String funcDefault(String n) {
        return n;
    }
}
