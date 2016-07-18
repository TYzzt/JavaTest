package c19;

import java.util.BitSet;

/**
 * Created by ZhaoTao on 2016/7/15.
 */
public class BitSetDemo {
    public static void main(String[] args) {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                bits1.set(i);
            }
            if (i % 5 == 0) {
                bits2.set(i);
            }
        }
        System.out.println("bits1:" + bits1);
        System.out.println("bits2:" + bits2);

        bits2.and(bits1);
        System.out.println("and:" + bits2);

        bits2.or(bits1);
        System.out.println("or:" + bits2);

        bits2.xor(bits1);
        System.out.println("xor:" + bits2);


    }
}
